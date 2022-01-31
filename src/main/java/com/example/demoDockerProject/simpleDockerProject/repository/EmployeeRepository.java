package com.example.demoDockerProject.simpleDockerProject.repository;

import com.example.demoDockerProject.simpleDockerProject.mongodb.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    @Query("{name:'?0'}")
    Optional<Employee> findItemByName(String name);

    @Query(value="{designation:'?0'}")
    List<Employee> findAll(String designation);
}
