package com.example.accessingdatamysql.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.accessingdatamysql.dao.StudentDAO;
import com.example.accessingdatamysql.entity.ClassRoom;
import com.example.accessingdatamysql.entity.Student;
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

        ClassRoom classRoom = query.getSingleResult();
        return classRoom.getStudents();
    }
}
