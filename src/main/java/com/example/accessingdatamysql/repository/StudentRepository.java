package com.example.accessingdatamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.accessingdatamysql.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
