package com.nishant.EmployeeManager.model.mysql;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    private Instant createdAt;

    private Instant updatedAt;

    public Employee(String firstName, String lastName, String email, String departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departmentId = departmentId;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
