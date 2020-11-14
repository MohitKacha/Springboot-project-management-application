package com.sprinboot.projectmanagement.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprinboot.projectmanagement.dao.IEmployeeRepository;
import com.sprinboot.projectmanagement.dao.IProjectRepository;
import com.sprinboot.projectmanagement.dto.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    IProjectRepository projectRepository;

    @Autowired
    IEmployeeRepository employeeRepository;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        model.addAttribute("projects",projectRepository.findAll());
        model.addAttribute("employeesListProject",employeeRepository.employeeProjects());
        List<ChartData> projectData = projectRepository.getProjectStatus();
        ObjectMapper objectMapper =  new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
       // model.addAttribute("")

        model.addAttribute("projectStatusCount",jsonString );

        return "main/home";
    }
}
