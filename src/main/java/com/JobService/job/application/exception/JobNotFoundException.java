package com.JobService.job.application.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JobNotFoundException extends RuntimeException {
    public JobNotFoundException(String id) {
        super("Job with id " + id + "not found.");
        log.error("Job with id {} not found.", id);
    }
}
