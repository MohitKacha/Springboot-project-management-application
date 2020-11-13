package com.sprinboot.projectmanagement.controllers;

import com.sprinboot.projectmanagement.dao.IEmployeeRepository;
import com.sprinboot.projectmanagement.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployee(Model model){
        model.addAttribute("employees",employeeRepository.findAll());
        return "employees/list-employees";
    }


    @GetMapping("/new")
    public String dispplayEmployeeForm(Model model){
        model.addAttribute("employee",new Employee());

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        employeeRepository.save(employee);
        return "redirect:/employees";
    }
}
