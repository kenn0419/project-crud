package com.kenn.project_crud.controller;

import com.kenn.project_crud.dto.ProjectCreateDTO;
import com.kenn.project_crud.dto.ProjectUpdateDTO;
import com.kenn.project_crud.model.Dept;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.service.DeptService;
import com.kenn.project_crud.service.ProjectService;
import com.kenn.project_crud.util.Constant;
import com.kenn.project_crud.util.Helper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/projects")
//@Validated
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;
    private final DeptService deptService;

    @GetMapping
    public String showProjectPage(Model model) {
        int pageSize = Constant.PAGE_SIZE_DEFAULT;
        List<Project> projects = this.projectService.getProjects("123", 1, pageSize);
        model.addAttribute("projects", projects);

        return "project/list";
    }

    @GetMapping("/create")
    public String showCreateProjectPage(Model model) {
        ProjectCreateDTO createDTO = new ProjectCreateDTO();
        List<Dept> depts = this.deptService.getAllDepts();
        model.addAttribute("newProject", createDTO);
        model.addAttribute("depts", depts);

        return "project/create";
    }

    @PostMapping("/create")
    public String createProject(@Valid @ModelAttribute("newProject") ProjectCreateDTO request,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<Dept> depts = this.deptService.getAllDepts();
            model.addAttribute("depts", depts);
            return "project/create";
        }
        try {
            this.projectService.createProject(request);
            model.addAttribute("successMessage", "Create project successfully");
            return "redirect:/projects";
        } catch (Exception e) {
            model.addAttribute("status", 400);
            model.addAttribute("errorMessage", e.getMessage());
            List<Dept> depts = this.deptService.getAllDepts();
            model.addAttribute("depts", depts);
            return "project/create";
        }
    }

    @GetMapping("/update/{projectId}")
    public String showUpdateProjectPage(Model model,
                                        @Min(1) @PathVariable("projectId") long projectId,
                                        RedirectAttributes redirectAttributes) {
        try {
            Project project = this.projectService.getProjectById(projectId);
            ProjectUpdateDTO projectUpdateDTO = Helper.toProjectUpdateDTO(project);
            model.addAttribute("updateProject", projectUpdateDTO);
            List<Dept> depts = this.deptService.getAllDepts();
            model.addAttribute("depts", depts);
            return "/project/update";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("status", 400);
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/projects";
        }
    }

    @PostMapping("/update")
    public String updateProject(@Valid @ModelAttribute("updateProject") ProjectUpdateDTO request,
                                BindingResult bindingResult, Model model) {
        try {
            this.projectService.updateProject(request);
            model.addAttribute("successMessage", "Update project successfully");
            return "redirect:/projects";
        } catch (Exception e) {
            model.addAttribute("status", 400);
            model.addAttribute("errorMessage", e.getMessage());
            List<Dept> depts = this.deptService.getAllDepts();
            model.addAttribute("depts", depts);
            return "project/update";
        }
    }

    @GetMapping("/delete/{projectId}")
    public String showDeleteProjectPage(Model model, @PathVariable("projectId") Long id) {
        Project project = this.projectService.getProjectById(id);
        model.addAttribute("deleteProject", project);

        return "project/delete";
    }

    @PostMapping("/delete")
    public String deleteProject(Model model, @ModelAttribute Long projectId) {
        try {
            this.projectService.deleteProject(projectId);
            model.addAttribute("successMessage", "Delete project successfully");
            return "redirect:/projects";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "project/delete";
        }
    }
}
