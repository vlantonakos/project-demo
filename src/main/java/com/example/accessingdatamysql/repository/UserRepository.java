package com.example.accessingdatamysql.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.accessingdatamysql.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
