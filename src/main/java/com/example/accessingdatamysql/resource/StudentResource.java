package com.example.accessingdatamysql.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.accessingdatamysql.dao.StudentDAO;
import com.example.accessingdatamysql.entity.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentResource {

    @Autowired
    private StudentDAO studentDAO;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestParam("name") String studentName,
            @RequestParam("classRoomId") Integer classRoomId) {
        try {
            Student savedStudent = studentDAO.addStudent(studentName, classRoomId);
            return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byStudent/{StudentName}")
    public List<Student> getStudentsByClassRoomName(@PathVariable String classRoomName) {
        return studentDAO.findAllStudentsByClassRoomName(classRoomName);
    }
}
