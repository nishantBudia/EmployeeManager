package com.nishant.EmployeeManager.controller;

import com.nishant.EmployeeManager.model.dto.CreateEmployeeDTO;
import com.nishant.EmployeeManager.model.dto.UpdateEmployeeDTO;
import com.nishant.EmployeeManager.model.postgres.Employee;
import com.nishant.EmployeeManager.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /*
    POST
     */

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid CreateEmployeeDTO createEmployeeDTO){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(createEmployeeDTO));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    GET
     */

    @GetMapping
    public List<Employee> getAllEmployeesPaginated(@RequestParam int pageNo){
        return employeeService.getAllEmployeesPaginated(pageNo);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long employeeId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(employeeId));
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    PUT
     */

    @PutMapping("{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long employeeId, @RequestBody UpdateEmployeeDTO updateEmployeeDTO){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployeeById(employeeId,updateEmployeeDTO));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    DELETE
     */

    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId){
        try{
            employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.status(HttpStatus.OK).body("Employee "+employeeId+" deleted");
        } catch (Exception e){
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("employee not found");
        }
    }
}
