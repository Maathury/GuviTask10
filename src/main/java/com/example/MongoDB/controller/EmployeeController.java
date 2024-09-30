package com.example.MongoDB.controller;

import com.example.MongoDB.dto.EmployeeDto;
import com.example.MongoDB.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private EmployeeService employeeService;

    @GetMapping("/homePage")
    public String  getAllEmployeeDetails(Model model){
        model.addAttribute("allEmpList",employeeService.getAllEmployees());
        return "index";
    }


    @GetMapping("/addNew")
    public String  addNewEmployee(Model model){
        EmployeeDto employee=new EmployeeDto();
        model.addAttribute("employee",employee);
        return "newEmployee";
    }

    @PostMapping("/save")
    public String addEmployee(@ModelAttribute("employee") EmployeeDto employee){
        employeeService.addEmployee(employee);
        return "redirect:/homePage";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String  addNewEmployee(@PathVariable String id, Model model){
        EmployeeDto employee=employeeService.getEmpById(id);
        model.addAttribute("employee",employee);
        return "update";
    }


    @GetMapping("deleteEmployee/{id}")
    public String  deleteEmployeeDetails(@PathVariable String  employeeId){
        employeeService.deleteEmployeeDetails(employeeId);
        return "redirect:/homePage";
    }
}
