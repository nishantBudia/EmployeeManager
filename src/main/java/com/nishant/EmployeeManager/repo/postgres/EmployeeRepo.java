package com.nishant.EmployeeManager.repo.postgres;

import com.nishant.EmployeeManager.model.postgres.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    boolean existsByDepartmentId(String departmentId);
}
