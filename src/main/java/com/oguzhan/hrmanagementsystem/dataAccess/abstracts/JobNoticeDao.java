package com.oguzhan.hrmanagementsystem.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oguzhan.hrmanagementsystem.entities.concretes.JobNotice;

public interface JobNoticeDao extends JpaRepository<JobNotice, Integer> {

}
