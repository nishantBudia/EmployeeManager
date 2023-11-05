package com.nishant.EmployeeManager.controller;

import com.nishant.EmployeeManager.model.dto.CreateDepartmentDTO;
import com.nishant.EmployeeManager.model.mongo.Department;
import com.nishant.EmployeeManager.service.DepartmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    /*
    POST
     */

    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody @Valid CreateDepartmentDTO createDepartmentDTO){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(departmentService.createDepartment(createDepartmentDTO));
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    GET
     */

    @GetMapping
    public List<Department> getAllDepartmentsPaginated(@RequestParam int pageNo){
        return departmentService.getAllDepartmentsPaginated(pageNo);
    }

    @GetMapping("{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable String departmentId){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.getDepartmentById(departmentId));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    PUT
     */

    @PutMapping("{departmentId}")
    public ResponseEntity<Department> updateDepartmentById(@PathVariable String departmentId, @RequestBody @NotEmpty String departmentName){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(departmentService.updateDepartmentById(departmentId,departmentName));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /*
    DELETE
     */

    @DeleteMapping("{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable String departmentId){
        try{
            departmentService.deleteDepartmentById(departmentId);
            return ResponseEntity.status(HttpStatus.OK).body("department "+departmentId+" deleted");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
