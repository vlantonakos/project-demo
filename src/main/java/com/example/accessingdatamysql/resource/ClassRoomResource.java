package com.example.accessingdatamysql.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.accessingdatamysql.dao.ClassRoomDAO;
import com.example.accessingdatamysql.entity.ClassRoom;
import com.example.accessingdatamysql.entity.Student;

@Controller
@RequestMapping(path = "/classRoom")
public class ClassRoomResource {

    @Autowired
    private ClassRoomDAO classRoomDAO;

    @PostMapping("/saveClassRoom")
    public ResponseEntity<ClassRoom> createClassRoom(@RequestBody ClassRoom classRoom) {
        try {
            ClassRoom savedClassRoom = classRoomDAO.save(classRoom);
            return new ResponseEntity<>(savedClassRoom, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addStudentToClassRoom/{classRoomId}")
    public ResponseEntity<ClassRoom> addStudentToClassRoom(@PathVariable Integer classRoomId, @RequestBody Student student) {
        try {
            ClassRoom classRoom = classRoomDAO.findById(classRoomId);
            if (classRoom != null) {
                classRoom.addStudent(student);
                classRoomDAO.save(classRoom);
                return new ResponseEntity<>(classRoom, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
