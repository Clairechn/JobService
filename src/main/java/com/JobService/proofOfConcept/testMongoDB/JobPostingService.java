package com.JobService.proofOfConcept.testMongoDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {

    @Autowired
    private JobPostingRepository repository;

    public List<JobPosting> getAllJobPostings() {
        return repository.findAll();
    }

    public JobPosting getJobPostingById(String id) {
        return repository.findById(id).orElse(null);
    }
}
