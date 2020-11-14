package com.sprinboot.projectmanagement.controllers;

import com.sprinboot.projectmanagement.dao.IEmployeeRepository;
import com.sprinboot.projectmanagement.dao.IProjectRepository;
import com.sprinboot.projectmanagement.entities.Employee;
import com.sprinboot.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private IProjectRepository projectRepository;
    private IEmployeeRepository employeeRepository;

    @Autowired
    ProjectController(IProjectRepository projectRepository,IEmployeeRepository employeeRepository){
        this.projectRepository = projectRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String displayProjects(Model model){
        model.addAttribute("projects",projectRepository.findAll());
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project", new Project());

        model.addAttribute("allEmployee", employeeRepository.findAll());
        return "projects/new-project";
    }


    @PostMapping("/save")
    public String createProject(Project project,   Model model){
        projectRepository.save(project);

        return "redirect:/projects";
    }

}
