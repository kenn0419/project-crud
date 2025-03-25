package com.kenn.project_crud.controller.api;


import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.service.impl.ProjectApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectApiController {

    private final ProjectApiService projectApiService;
    @GetMapping
    public PageResponse<List<Project>> getProjects(@RequestParam(defaultValue = "", required = false) String search,
                                                   @RequestParam(defaultValue = "1", required = false) int pageNo,
                                                   @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return this.projectApiService.getProjects(search, pageNo, pageSize);
    }
}
