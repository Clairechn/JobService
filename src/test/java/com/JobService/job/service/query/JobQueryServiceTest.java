package com.JobService.job.service.query;

import com.JobService.job.application.service.query.JobQueryService;
import com.JobService.job.application.usecase.query.FindAllJobs;
import com.JobService.job.application.usecase.query.FindJobDescriptionById;
import com.JobService.job.application.usecase.query.FindJobDetailsById;
import com.JobService.job.domain.entity.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobQueryServiceTest {

    @Mock
    private FindAllJobs findAllJobs;
    @Mock
    private FindJobDescriptionById findJobDescriptionById;
    @Mock
    private FindJobDetailsById findJobDetailsById;

    private JobQueryService jobQueryService;

    @BeforeEach
    void setUp() {
        jobQueryService = new JobQueryService(findJobDetailsById, findJobDescriptionById, findAllJobs);
    }

    @Test
    void findAllJobs_shouldReturnAllJobs() {
        // Arrange
        Job job1 = Job.builder().id("1").title("Software Engineer").build();
        Job job2 = Job.builder().id("2").title("Data Scientist").build();

        List<Job> expectedJobs = Arrays.asList(job1, job2);
        when(findAllJobs.execute()).thenReturn(expectedJobs);

        // Act
        List<Job> actualJobs = jobQueryService.findAllJobs();

        // Assert
        assertEquals(expectedJobs, actualJobs);
        verify(findAllJobs, times(1)).execute();
    }
}
