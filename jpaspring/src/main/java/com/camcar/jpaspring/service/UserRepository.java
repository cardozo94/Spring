package com.camcar.jpaspring.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camcar.jpaspring.entity.User;

public interface UserRepository extends JpaRepository<User, Long > {

}
