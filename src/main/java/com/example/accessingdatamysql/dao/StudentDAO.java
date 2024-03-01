package com.example.accessingdatamysql.dao;

import java.util.List;
import java.util.Optional;

import com.example.accessingdatamysql.entity.Student;

public interface StudentDAO {

    Student save(Student student);

    Optional<Student> findById(int id);

    List<Student> findAll();

    List<Student> findAllStudentsByClassRoomName(String classRoomName);

    Student addStudent(String studentName, Integer classRoomId);
}
