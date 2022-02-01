package com.example.demoDockerProject.simpleDockerProject.controllers;

import com.example.demoDockerProject.simpleDockerProject.mongodb.Employee;
import com.example.demoDockerProject.simpleDockerProject.repository.CustomEmployeeRepositoryImpl;
import com.example.demoDockerProject.simpleDockerProject.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class employeeControllers {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomEmployeeRepositoryImpl customEmployeeRepository;

    Logger logger = LoggerFactory.getLogger(employeeControllers.class);

    @GetMapping("/employees")
    public List<Optional<Employee>> allEmployees(@RequestParam(required = false) String id,@RequestParam(required = false) String name){
        logger.info("Listing employees");
        List<Optional<Employee>> employees = new ArrayList<>();
        if(id!=null && employeeRepository.findById(id).isPresent())
            employees.add(employeeRepository.findById(id));
        else if(name!=null && employeeRepository.findItemByName(name).isPresent())
            employees.add(employeeRepository.findItemByName(name));
        else {
            employeeRepository.findAll().forEach(employee -> employees.add(Optional.ofNullable(employee)));
        }
        logger.info("List of employees :: {}",employees);
        return employees;
    }

    @GetMapping("/employees/{designation}")
    public List<Employee> allEmployeesWithDesignation(@PathVariable String designation){
        logger.info("Listing all employees with designation :: {}",designation);
        return employeeRepository.findAll(designation);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        logger.info("Adding an employee :: {}",employee);
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/employees")
    public void deleteEmployee(@RequestParam String id){
        logger.info("Deleting an employee with id :: {}",id);
        employeeRepository.deleteById(id);
    }

    @PutMapping("/employeesDesignationUpdate")
    public void updateEmployeeDesignation(@RequestParam String employeeName,@RequestParam String designation){
        logger.info("Updating employee designation :: {} for name :: {}",designation,employeeName);
        customEmployeeRepository.updateDesignation(employeeName,designation);
    }

    @PutMapping("/employeesUpdate")
    public void updateEmployeeDesignation(@RequestBody Employee employee){
        logger.info("Updating employee with the details :: {}",employee);
        employeeRepository.save(employee);
    }
}
