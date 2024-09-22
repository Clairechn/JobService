package com.JobService.job.domain.entity;

import com.JobService.common.domain.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Entity
@Getter
@Setter
@Builder
public class Job extends BaseEntity {
    @MongoId(FieldType.OBJECT_ID)
    private String id;
    private String applicationsCount;
    private Long companyId;
    private String companyName;
    private String contractType;
    private String description;
    private String experienceLevel;
    private String location;
    private String postedTime;
    private String publishedAt;
    private String salary;
    private String sector;
    private String title;
    private String workType;
    private String source;

    protected void onCreate() {
        super.onCreate();
    }

    @Override
    public String toString() {
        return "Job {" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
