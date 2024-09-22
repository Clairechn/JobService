package com.JobService.job.api.query;

import com.JobService.job.application.dto.query.JobResponseDescriptionDto;
import com.JobService.job.application.service.query.JobQueryService;
import com.JobService.job.domain.entity.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/jobs/query")
public class JobQueryController {

    private final JobQueryService jobQueryService;

    public JobQueryController(JobQueryService jobQueryService) {
        this.jobQueryService = jobQueryService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Job>> findAllJobs() {
        List<Job> jobs = jobQueryService.findAllJobs();
        return ResponseEntity.ok(jobs);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<Job> findJobDetailsById(@PathVariable String id) {
        Optional<Job> job = jobQueryService.findJobDetailsById(id);
        return job.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/description/{id}")
    public ResponseEntity<JobResponseDescriptionDto> findJobDescriptionById(@PathVariable String id) {
        Optional<JobResponseDescriptionDto> jobResponseDescriptionDto = jobQueryService.findJobDescriptionById(id);
        return jobResponseDescriptionDto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
