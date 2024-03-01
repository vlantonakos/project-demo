package com.example.accessingdatamysql.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @OneToMany(mappedBy = "classRoom", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public ClassRoom() {
        // Default constructor
    }

    public ClassRoom(String classRoomName) {
        this.classRoomName = classRoomName;
    }

    public ClassRoom(String classRoomName, List<Student> students) {
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // Method to concatenate student names separated by commas
    public String getStudentNames() {
        StringBuilder namesBuilder = new StringBuilder();
        for (Student student : students) {
            namesBuilder.append(student.getStudentName()).append(",");
        }
        if (namesBuilder.length() > 0) {
            namesBuilder.setLength(namesBuilder.length() - 1); // Remove the last comma
        }
        return namesBuilder.toString();
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
        student.setClassRoom(this);
    }

}
