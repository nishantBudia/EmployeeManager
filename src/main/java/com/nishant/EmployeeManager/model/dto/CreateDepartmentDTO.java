package com.nishant.EmployeeManager.model.dto;

import com.nishant.EmployeeManager.model.mongo.Department;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentDTO {
    @NotEmpty
    private String departmentName;

    public Department createDepartment(){
        return new Department(this.departmentName);
    }
}
