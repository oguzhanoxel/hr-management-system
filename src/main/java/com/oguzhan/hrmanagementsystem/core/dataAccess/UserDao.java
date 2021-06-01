package com.oguzhan.hrmanagementsystem.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.core.entities.User;


public interface UserDao extends JpaRepository<User, Integer> {

}
