package com.example.demoDockerProject.simpleDockerProject.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document("employee")
@Data
public class Employee {
    @Id
    private String id;
    private String name;
    private String designation;
    private Map<String,Object> meta;
}
