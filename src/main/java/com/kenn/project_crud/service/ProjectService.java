package com.kenn.project_crud.service;

import com.kenn.project_crud.dto.request.ProjectCreateDTO;
import com.kenn.project_crud.dto.request.ProjectQueryRequest;
import com.kenn.project_crud.dto.request.ProjectUpdateDTO;
import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.dto.response.ProjectResponseDTO;
import com.kenn.project_crud.form.ProjectQueryForm;
import com.kenn.project_crud.model.Project;

import java.util.List;

public interface ProjectService {
    public void createProject(ProjectCreateDTO request);

    public PageResponse<List<ProjectResponseDTO>> getProjects(ProjectQueryRequest projectQueryRequest);

    public Project getProjectById(Long projectId);

    public void updateProject(ProjectUpdateDTO request);

    public void deleteProject(Long projectId);
}
