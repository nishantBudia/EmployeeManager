package com.nishant.EmployeeManager.model.mongo;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("departments")
public class Department {
    @MongoId
    private String id;

    @NotEmpty
    @Indexed(unique = true)
    private String departmentName;

    private Instant createdAt;

    private Instant updatedAt;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
}
