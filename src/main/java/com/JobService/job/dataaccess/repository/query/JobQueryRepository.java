package com.JobService.job.dataaccess.repository.query;

import com.JobService.job.domain.entity.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobQueryRepository extends MongoRepository<Job, String> {
}
