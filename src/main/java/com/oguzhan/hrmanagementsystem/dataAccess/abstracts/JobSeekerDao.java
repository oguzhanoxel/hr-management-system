package com.oguzhan.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

	List<JobSeeker> findByEmailOrTcNo(String email, String tcNo);
	
}
