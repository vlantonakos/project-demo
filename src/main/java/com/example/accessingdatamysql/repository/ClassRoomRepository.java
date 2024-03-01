package com.example.accessingdatamysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.accessingdatamysql.entity.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Integer> {

}
