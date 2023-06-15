package com.jonatas.novo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonatas.novo.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
