package com.JobService.job.application.query;

import com.JobService.job.application.usecase.query.FindAllJobs;
import com.JobService.job.dataaccess.adapter.JobPersistenceAdapter;
import com.JobService.job.domain.entity.Job;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FindAllJobsTest {

    @Mock
    private JobPersistenceAdapter jobPersistenceAdapter;

    private FindAllJobs findAllJobs;

    @BeforeEach
    void setUp() {
        findAllJobs = new FindAllJobs(jobPersistenceAdapter);
    }

    @Test
    void execute_shouldReturnAllJobs() {
        // Arrange
        Job job1 = Job.builder().id("1").title("Software Engineer").build();
        Job job2 = Job.builder().id("2").title("Data Scientist").build();

        List<Job> expectedJobs = Arrays.asList(job1, job2);
        when(jobPersistenceAdapter.findAllJobs()).thenReturn(expectedJobs);

        // Act
        List<Job> actualJobs = findAllJobs.execute();

        // Assert
        assertEquals(expectedJobs, actualJobs);
        verify(jobPersistenceAdapter, times(1)).findAllJobs();
    }

    @Test
    void execute_shouldThrowException_whenPersistenceAdatperFails() {
        // Arrange
        when(jobPersistenceAdapter.findAllJobs()).thenThrow(new RuntimeException("Database error"));

        // Act & Assert
        assertThrows(RuntimeException.class, () -> findAllJobs.execute());
        verify(jobPersistenceAdapter, times(1)).findAllJobs();
    }
}
