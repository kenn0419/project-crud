package com.kenn.project_crud.service;

import com.kenn.project_crud.dto.request.ProjectCreateDTO;
import com.kenn.project_crud.dto.request.ProjectUpdateDTO;
import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.model.Project;

import java.util.List;

public interface ProjectService {
    public void createProject(ProjectCreateDTO request);

    public PageResponse<List<Project>> getProjects(String search, int pageNo, int pageSize);

    public Project getProjectById(Long projectId);

    public void updateProject(ProjectUpdateDTO request);

    public void deleteProject(Long projectId);
}
