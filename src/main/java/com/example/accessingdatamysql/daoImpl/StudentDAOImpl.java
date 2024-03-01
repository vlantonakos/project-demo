package com.example.accessingdatamysql.daoImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.accessingdatamysql.dao.StudentDAO;
import com.example.accessingdatamysql.entity.ClassRoom;
import com.example.accessingdatamysql.entity.Student;
import com.example.accessingdatamysql.repository.ClassRoomRepository;
import com.example.accessingdatamysql.repository.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Override
    @Transactional
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllStudentsByClassRoomName(String classRoomName) {
        TypedQuery<ClassRoom> query = em.createQuery(
                "SELECT c FROM ClassRoom c WHERE c.classRoomName = :classRoomName",
                ClassRoom.class);
        query.setParameter("classRoomName", classRoomName);

        List<ClassRoom> classRooms = query.getResultList();
        if (classRooms.isEmpty()) {
            // No class room found with the given name
            return Collections.emptyList();
        } else {
            // Retrieve students from all matching class rooms
            List<Student> students = new ArrayList<>();
            for (ClassRoom classRoom : classRooms) {
                students.addAll(classRoom.getStudents());
            }
            return students;
        }
    }

    public Student addStudent(String studentName, Integer classRoomId) {
        // Find the class room by its ID
        ClassRoom classRoom = classRoomRepository.findById(classRoomId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class room ID"));

        // Create a new student and set its class room
        Student student = new Student(studentName, classRoom);
        return studentRepository.save(student);
    }
}
