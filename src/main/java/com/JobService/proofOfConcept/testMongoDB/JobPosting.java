package com.JobService.proofOfConcept.testMongoDB;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "job")
@Data
public class JobPosting {
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

    // Getters and setters
    // ... (省略getter和setter方法，實際使用時需要添加)

    @Override
    public String toString() {
        return "JobPosting{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}