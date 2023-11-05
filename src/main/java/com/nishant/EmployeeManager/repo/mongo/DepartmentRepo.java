package com.nishant.EmployeeManager.repo.mongo;

import com.nishant.EmployeeManager.model.mongo.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends MongoRepository<Department, String> {
}
