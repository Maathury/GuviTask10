package com.example.MongoDB.repository;

import com.example.MongoDB.dto.EmployeeDto;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository <EmployeeDto,String> {

    void deleteByEmployeeId(String employeeId);


    Optional<EmployeeDto> findByEmployeeId(String employeeId);
}
