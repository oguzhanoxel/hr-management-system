package com.oguzhan.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {

}
