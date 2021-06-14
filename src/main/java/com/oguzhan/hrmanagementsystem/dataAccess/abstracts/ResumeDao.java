package com.oguzhan.hrmanagementsystem.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer> {

	List<Resume> findByJobSeeker_Id(int jobSeekerId);
	
}
