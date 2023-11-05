package com.nishant.EmployeeManager.service;

import com.nishant.EmployeeManager.model.dto.CreateDepartmentDTO;
import com.nishant.EmployeeManager.model.mongo.Department;
import com.nishant.EmployeeManager.repo.mongo.DepartmentRepo;
import com.nishant.EmployeeManager.repo.postgres.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    public Department createDepartment(CreateDepartmentDTO createDepartmentDTO) {
        return departmentRepo.save(createDepartmentDTO.createDepartment());
    }

    public List<Department> getAllDepartmentsPaginated(int pageNo) {
        return departmentRepo.findAll(PageRequest.of(pageNo,10)).getContent();
    }

    public Department getDepartmentById(String departmentId) throws Exception {
        return departmentRepo.findById(departmentId).orElseThrow(()-> new Exception("department does not exist"));
    }

    public Department updateDepartmentById(String departmentId, String departmentName) throws Exception {
        Department departmentToBeUpdated = departmentRepo.findById(departmentId).orElseThrow(()->new Exception("department not found"));

        departmentToBeUpdated.setDepartmentName(departmentName);

        departmentToBeUpdated.setUpdatedAt(Instant.now());

        return departmentRepo.save(departmentToBeUpdated);
    }

    public void deleteDepartmentById(String departmentId) throws Exception {
        if(employeeRepo.existsByDepartmentId(departmentId)){
            throw new Exception("Employees present in department");
        }

        departmentRepo.deleteById(departmentId);
    }
}
