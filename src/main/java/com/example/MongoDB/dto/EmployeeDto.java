package com.example.MongoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "employee")

public class EmployeeDto {

    @Id
    private String employeeId;

    private String employeeName;
    private String employeeEmail;
    private String employeeLocation;

}
