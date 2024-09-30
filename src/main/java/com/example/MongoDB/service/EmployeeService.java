package com.example.MongoDB.service;

import com.example.MongoDB.dto.EmployeeDto;
import com.example.MongoDB.repository.EmployeeRepository;
import com.example.MongoDB.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class EmployeeService  {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;


    public void save(EmployeeDto employeeDto) {
        EmployeeDto employee = modelMapper.map(employeeDto, EmployeeDto.class);
        employeeRepository.save(employee);
    }


    public EmployeeDto getEmpById(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId).get();
    }


    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> modelMapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
    }


    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        EmployeeDto employee=modelMapper.map(employeeDto,EmployeeDto.class);
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeDetails(String id) {
        employeeRepository.deleteByEmployeeId(id);
    }
}
