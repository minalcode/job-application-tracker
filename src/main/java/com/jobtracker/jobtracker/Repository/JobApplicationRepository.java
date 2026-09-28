package com.jobtracker.jobtracker.Repository;

import com.jobtracker.jobtracker.Model.ApplicationStatus;
import com.jobtracker.jobtracker.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    List<JobApplication> findByStatus(ApplicationStatus status);
}