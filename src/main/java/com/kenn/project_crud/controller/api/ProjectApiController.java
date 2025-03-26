package com.kenn.project_crud.controller.api;


import com.kenn.project_crud.dto.request.ProjectCreateDTO;
import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.dto.response.ProjectResponseDTO;
import com.kenn.project_crud.logic.ProjectLogic;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.service.impl.ProjectApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectApiController {

    private final ProjectApiService projectApiService;
    private final ProjectLogic projectLogic;

    @GetMapping
    public PageResponse<List<Project>> getProjects(@RequestParam(defaultValue = "", required = false) String search,
                                                   @RequestParam(defaultValue = "1", required = false) int pageNo,
                                                   @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return this.projectApiService.getProjects(search, pageNo, pageSize);
    }

    @PostMapping
    public String registerProject(@ModelAttribute("newProject") ProjectCreateDTO request, BindingResult bindingResult, Model model) {
        ProjectResponseDTO projectResponseDTO = this.projectLogic.processRegisterProject(request, bindingResult, projectApiService);
        if (bindingResult.hasErrors()) {
            return "project/create";
        }
        model.addAttribute("project", projectResponseDTO);

        return "project/complete";
    }
}
