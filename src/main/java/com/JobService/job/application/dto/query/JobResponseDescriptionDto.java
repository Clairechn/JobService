package com.JobService.job.application.dto.query;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JobResponseDescriptionDto {
    private String id;
    private String description;
}
