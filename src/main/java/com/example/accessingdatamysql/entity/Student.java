package com.example.accessingdatamysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String studentName;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    @JsonIgnore
    private ClassRoom classRoom;

    public Student() {
        // Default constructor
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public Student(String studentName, ClassRoom classRoom) {
        this.studentName = studentName;
        this.classRoom = classRoom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

}
