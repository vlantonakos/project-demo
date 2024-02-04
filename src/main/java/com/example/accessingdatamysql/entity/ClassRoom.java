package com.example.accessingdatamysql.entity;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String classRoomName;

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL)
    private ArrayList<Student> students;

    public ClassRoom(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public ClassRoom(String classRoomName, ArrayList<Student> students) {
        this.classRoomName = classRoomName;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassRoomName() {
        return classRoomName;
    }

    public void setClassRoomName(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

}
