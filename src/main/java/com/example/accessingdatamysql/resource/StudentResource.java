package com.example.accessingdatamysql.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.accessingdatamysql.dao.StudentDAO;
import com.example.accessingdatamysql.entity.Student;

@Controller
@RequestMapping(path = "/student")
public class StudentResource {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/byClassRoom/{classRoomName}")
    public List<Student> getStudentsByClassRoomName(@PathVariable String classRoomName) {
        return studentDAO.findAllStudentsByClassRoomName(classRoomName);
    }
}
