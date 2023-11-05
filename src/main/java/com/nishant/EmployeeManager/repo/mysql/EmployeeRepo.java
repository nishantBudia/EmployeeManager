package com.nishant.EmployeeManager.repo.mysql;

import com.nishant.EmployeeManager.model.mysql.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean existsByDepartmentId(String departmentId);
}
