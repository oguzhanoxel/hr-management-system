package com.oguzhan.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {
	
	List<Employer> findByEmail(String email);

}
