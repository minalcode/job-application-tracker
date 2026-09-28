package com.jobtracker.jobtracker.Controller;

import com.jobtracker.jobtracker.Model.ApplicationStatus;
import com.jobtracker.jobtracker.Model.JobApplication;
import com.jobtracker.jobtracker.Service.JobApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class JobApplicationController {

    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    // Add application
    @PostMapping
    public JobApplication addApplication(
            @RequestBody JobApplication application) {

        return service.addApplication(application);
    }

    // Get all applications
    @GetMapping
    public List<JobApplication> getAllApplications() {

        return service.getAllApplications();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(
            @PathVariable Long id) {

        return service.getApplicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update application
    @PutMapping("/{id}")
    public JobApplication updateApplication(
            @PathVariable Long id,
            @RequestBody JobApplication application) {

        return service.updateApplication(id, application);
    }

    // Delete application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(
            @PathVariable Long id) {

        service.deleteApplication(id);

        return ResponseEntity.ok("Application deleted successfully");
    }

    // Get applications by status
    @GetMapping("/status/{status}")
    public List<JobApplication> getApplicationsByStatus(
            @PathVariable ApplicationStatus status) {

        return service.getApplicationsByStatus(status);
    }
}