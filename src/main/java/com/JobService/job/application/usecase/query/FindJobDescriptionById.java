package com.JobService.job.application.usecase.query;

import com.JobService.job.application.dto.query.JobResponseDescriptionDto;
import com.JobService.job.application.exception.JobNotFoundException;
import com.JobService.job.dataaccess.adapter.JobPersistenceAdapter;
import com.JobService.job.domain.entity.Job;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindJobDescriptionById {

    private final JobPersistenceAdapter jobPersistenceAdapter;

    public FindJobDescriptionById(JobPersistenceAdapter jobPersistenceAdapter) {
        this.jobPersistenceAdapter = jobPersistenceAdapter;
    }

    public Optional<JobResponseDescriptionDto> execute(String id) {
        try {
            log.info("Finding description with id: {}", id);
            Optional<Job> job = jobPersistenceAdapter.findById(id);
            if (job.isPresent()) {
                log.info("Job description found with id: {}", id);
                return Optional.ofNullable(JobResponseDescriptionDto
                        .builder()
                        .id(job.get().getId())
                        .description(job.get().getDescription())
                        .build());
            } else {
                throw new JobNotFoundException(id);
            }
        } catch (JobNotFoundException e) {
            log.error("Job with id {} not found.", id);
            throw e;
        } catch (Exception e) {
            log.error("Error occurred while finding job with id: {}", id, e);
            throw e;
        }
    }
}
