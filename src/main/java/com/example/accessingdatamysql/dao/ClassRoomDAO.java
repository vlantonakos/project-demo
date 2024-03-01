package com.example.accessingdatamysql.dao;


import com.example.accessingdatamysql.entity.ClassRoom;

public interface ClassRoomDAO {

    ClassRoom save(ClassRoom classRoom);

    ClassRoom findById(Integer classRoomId);

}
