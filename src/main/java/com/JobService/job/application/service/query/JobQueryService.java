package com.JobService.job.application.service.query;

import com.JobService.job.application.dto.query.JobResponseDescriptionDto;
import com.JobService.job.application.usecase.query.FindAllJobs;
import com.JobService.job.application.usecase.query.FindJobDescriptionById;
import com.JobService.job.application.usecase.query.FindJobDetailsById;
import com.JobService.job.domain.entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobQueryService {

    private final FindJobDetailsById findJobDetailsById;
    private final FindJobDescriptionById findJobDescriptionById;
    private final FindAllJobs findAllJobs;

    public JobQueryService(FindJobDetailsById findJobDetailsById, FindJobDescriptionById findJobDescriptionById, FindAllJobs findAllJobs) {
        this.findJobDetailsById = findJobDetailsById;
        this.findJobDescriptionById = findJobDescriptionById;
        this.findAllJobs = findAllJobs;
    }

    public Optional<Job> findJobDetailsById(String id) {
        return findJobDetailsById.execute(id);
    }

    public Optional<JobResponseDescriptionDto> findJobDescriptionById(String id) {
        return findJobDescriptionById.execute(id);
    }

    public List<Job> findAllJobs() {
        return findAllJobs.execute();
    }
}
