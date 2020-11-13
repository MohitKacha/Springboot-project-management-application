package com.sprinboot.projectmanagement.controllers;

import com.sprinboot.projectmanagement.dao.IProjectRepository;
import com.sprinboot.projectmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {


    @Autowired
    IProjectRepository projectRepository;

    @GetMapping
    public String displayProjects(Model model){
        model.addAttribute("projects",projectRepository.findAll());
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project", new Project());
        return "projects/new-project";
    }


    @PostMapping("/save")
    public String createProject(Project project,Model model){
        System.out.println(project);
        projectRepository.save(project);
        return "redirect:/projects";
    }

}
