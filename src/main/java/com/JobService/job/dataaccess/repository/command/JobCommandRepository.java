package com.JobService.job.dataaccess.repository.command;

import com.JobService.job.domain.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobCommandRepository extends MongoRepository<Job, String> {
}
