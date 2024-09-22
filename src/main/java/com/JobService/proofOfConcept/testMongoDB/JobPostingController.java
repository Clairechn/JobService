package com.JobService.proofOfConcept.testMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/test/job-postings")
public class JobPostingController {

    @Autowired
    private JobPostingService service;

    @GetMapping("/")
    public List<JobPosting> getAllJobPostings() {
        return service.getAllJobPostings();
    }

    @GetMapping("/{id}")
    public JobPosting getJobPostingById(@PathVariable String id) {
        return service.getJobPostingById(id);
    }
}
