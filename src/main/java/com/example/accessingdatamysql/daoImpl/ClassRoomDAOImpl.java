package com.example.accessingdatamysql.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.accessingdatamysql.dao.ClassRoomDAO;
import com.example.accessingdatamysql.entity.ClassRoom;
import com.example.accessingdatamysql.repository.ClassRoomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ClassRoomDAOImpl implements ClassRoomDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    ClassRoomRepository classRoomRepository;

    @Override
    @Transactional
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public ClassRoom findById(Integer classRoomId) {
        return em.find(ClassRoom.class, classRoomId);
    }
}
