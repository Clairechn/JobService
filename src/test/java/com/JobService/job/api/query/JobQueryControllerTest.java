package com.JobService.job.api.query;

import com.JobService.job.application.service.query.JobQueryService;
import com.JobService.job.domain.entity.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JobQueryControllerTest {

    @Mock
    private JobQueryService jobQueryService;

    @InjectMocks
    private JobQueryController jobQueryController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllJobs_shouldReturnAllJobs() {
        // Arrange
        List<Job> expectedJobs = Arrays.asList(Job.builder().build(), Job.builder().build());
        when(jobQueryService.findAllJobs()).thenReturn(expectedJobs);

        // Act
        ResponseEntity<List<Job>> response = jobQueryController.findAllJobs();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedJobs, response.getBody());
        verify(jobQueryService, times(1)).findAllJobs();
    }
}
