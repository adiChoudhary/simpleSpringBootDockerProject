package com.example.demoDockerProject.simpleDockerProject.controllers;

import com.example.demoDockerProject.simpleDockerProject.mongodb.Employee;
import com.example.demoDockerProject.simpleDockerProject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class employeeControllers {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Optional<Employee>> allEmployees(@RequestParam(required = false) String id,@RequestParam(required = false) String name){
        List<Optional<Employee>> employees = new ArrayList<>();
        if(id!=null && employeeRepository.findById(id).isPresent())
            employees.add(employeeRepository.findById(id));
        else if(name!=null && employeeRepository.findItemByName(name).isPresent())
            employees.add(employeeRepository.findItemByName(name));
        else {
            employeeRepository.findAll().forEach(employee -> employees.add(Optional.ofNullable(employee)));
        }
        return employees;
    }

    @GetMapping("/employees/{designation}")
    public List<Employee> allEmployeesWithDesignation(@PathVariable String designation){
        return employeeRepository.findAll(designation);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }


}
