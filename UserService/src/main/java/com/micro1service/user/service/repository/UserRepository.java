package com.micro1service.user.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.micro1service.user.service.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
