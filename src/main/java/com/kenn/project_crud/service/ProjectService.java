package com.kenn.project_crud.service;

import com.kenn.project_crud.dto.ProjectCreateDTO;
import com.kenn.project_crud.dto.ProjectUpdateDTO;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.util.Constant;

import java.awt.print.Pageable;
import java.util.List;

public interface ProjectService {
    public void createProject(ProjectCreateDTO request);

    public List<Project> getProjects(String search, int pageNo, int pageSize);

    public Project getProjectById(Long projectId);

    public void updateProject(ProjectUpdateDTO request);

    public void deleteProject(Long projectId);
}
