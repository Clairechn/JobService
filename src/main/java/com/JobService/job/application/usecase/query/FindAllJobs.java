package com.JobService.job.application.usecase.query;

import com.JobService.job.dataaccess.adapter.JobPersistenceAdapter;
import com.JobService.job.domain.entity.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FindAllJobs {

    private final JobPersistenceAdapter jobPersistenceAdapter;

    public FindAllJobs(JobPersistenceAdapter jobPersistenceAdapter) {
        this.jobPersistenceAdapter = jobPersistenceAdapter;
    }

    public List<Job> execute() {
        try {
            log.info("Finding all jobs");
            return jobPersistenceAdapter.findAllJobs();
        } catch (Exception e) {
            log.error("Error occurred while finding all jobs", e);
            throw e;
        }
    }

}
