package com.JobService.job.dataaccess.adapter;

import com.JobService.job.dataaccess.repository.query.JobQueryRepository;
import com.JobService.job.domain.entity.Job;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobPersistenceAdapter {

    private final JobQueryRepository jobQueryRepository;

    public JobPersistenceAdapter(JobQueryRepository jobQueryRepository) {
        this.jobQueryRepository = jobQueryRepository;
    }

    public Optional<Job> findById(String id) {
        return jobQueryRepository.findById(id);
    }

    public List<Job> findAllJobs() {
        return jobQueryRepository.findAll();
    }
}
