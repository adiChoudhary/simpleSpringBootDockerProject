package com.example.demoDockerProject.simpleDockerProject.repository;

import com.example.demoDockerProject.simpleDockerProject.mongodb.Employee;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

@Component
public class CustomEmployeeRepositoryImpl  implements  CustomEmployeeRepository{
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateDesignation(String employeeName, String newDesignation) {
        Query query = new Query(Criteria.where("name").is(employeeName));
        Update update = new Update();
        update.set("designation",newDesignation);
        UpdateResult result = mongoTemplate.updateFirst(query,update, Employee.class);
        if(result == null)
            System.out.println("No documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) updated..");
    }
}
