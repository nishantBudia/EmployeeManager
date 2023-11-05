package com.nishant.EmployeeManager.service;

import com.nishant.EmployeeManager.model.dto.CreateEmployeeDTO;
import com.nishant.EmployeeManager.model.dto.UpdateEmployeeDTO;
import com.nishant.EmployeeManager.model.postgres.Employee;
import com.nishant.EmployeeManager.repo.mongo.DepartmentRepo;
import com.nishant.EmployeeManager.repo.postgres.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;

    public Employee createEmployee(CreateEmployeeDTO createEmployeeDTO) throws Exception {
        if(!departmentRepo.existsById(createEmployeeDTO.getDepartmentId())){
            throw new Exception("department not found");
        }
        return employeeRepo.save(createEmployeeDTO.createEmployee());
    }

    public List<Employee> getAllEmployeesPaginated(int pageNo) {
        return employeeRepo.findAll(PageRequest.of(pageNo,10, Sort.by("id"))).getContent();
    }

    public Employee getEmployeeById(Long employeeId) throws Exception {
        return employeeRepo.findById(employeeId).orElseThrow(()->new Exception("employee not found"));
    }

    public Employee updateEmployeeById(Long employeeId,UpdateEmployeeDTO updateEmployeeDTO) throws Exception {

        Employee employeeToBeUpdated = employeeRepo.findById(employeeId).orElseThrow(()->new Exception("employee not found"));

        if(updateEmployeeDTO.getEmail()!=null){
            employeeToBeUpdated.setEmail(updateEmployeeDTO.getEmail());
        }

        if(updateEmployeeDTO.getDepartmentId()!=null){
            if(!departmentRepo.existsById(updateEmployeeDTO.getDepartmentId())){
                throw new Exception("department not found");
            }
            employeeToBeUpdated.setDepartmentId(updateEmployeeDTO.getDepartmentId());
        }
        employeeToBeUpdated.setUpdatedAt(Instant.now());

        return employeeRepo.save(employeeToBeUpdated);
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepo.deleteById(employeeId);
    }

}
