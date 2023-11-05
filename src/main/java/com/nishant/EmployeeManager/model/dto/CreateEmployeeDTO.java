package com.nishant.EmployeeManager.model.dto;

import com.nishant.EmployeeManager.model.mysql.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeDTO {
    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[A-Z][a-z]*$")
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    private String departmentId;

    public Employee createEmployee(){
        return new Employee(firstName,lastName,email,departmentId);
    }
}
