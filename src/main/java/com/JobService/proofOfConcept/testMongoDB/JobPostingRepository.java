package com.JobService.proofOfConcept.testMongoDB;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostingRepository extends MongoRepository<JobPosting, String> {
}
