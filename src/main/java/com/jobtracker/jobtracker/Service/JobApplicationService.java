package com.jobtracker.jobtracker.Service;

import com.jobtracker.jobtracker.Model.ApplicationStatus;
import com.jobtracker.jobtracker.Model.JobApplication;
import com.jobtracker.jobtracker.Repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private final JobApplicationRepository repository;

    public JobApplicationService(JobApplicationRepository repository) {
        this.repository = repository;
    }

    public JobApplication addApplication(JobApplication application) {
        return repository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    public Optional<JobApplication> getApplicationById(Long id) {
        return repository.findById(id);
    }

    public JobApplication updateApplication(Long id, JobApplication application) {

        JobApplication existingApplication = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found"));

        existingApplication.setCompanyName(application.getCompanyName());
        existingApplication.setPosition(application.getPosition());
        existingApplication.setStatus(application.getStatus());
        existingApplication.setAppliedDate(application.getAppliedDate());
        existingApplication.setInterviewDate(application.getInterviewDate());

        return repository.save(existingApplication);
    }

    public void deleteApplication(Long id) {
        repository.deleteById(id);
    }

    public List<JobApplication> getApplicationsByStatus(ApplicationStatus status) {
        return repository.findByStatus(status);
    }
}