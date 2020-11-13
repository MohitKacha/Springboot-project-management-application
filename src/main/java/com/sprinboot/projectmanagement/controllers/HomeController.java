package com.sprinboot.projectmanagement.controllers;

import com.sprinboot.projectmanagement.dao.IEmployeeRepository;
import com.sprinboot.projectmanagement.dao.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model){
        model.addAttribute("projects",projectRepository.findAll());
        model.addAttribute("employees",employeeRepository.findAll());
        return "main/home";
    }
}
