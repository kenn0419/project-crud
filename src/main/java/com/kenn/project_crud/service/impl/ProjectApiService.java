package com.kenn.project_crud.service.impl;


import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.dto.response.ProjectResponseDTO;
import com.kenn.project_crud.mapper.ProjectMapper;
import com.kenn.project_crud.model.Project;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectApiService {

    private final ProjectMapper projectMapper;

    public PageResponse<List<Project>> getProjects(String search, int pageNo, int pageSize) {
        search = (search == null || search.trim().isEmpty()) ? null : "%" + search + "%";

        int offset = (pageNo - 1) * pageSize;
        List<Project> projects = projectMapper.findAll(search, offset, pageSize);
        int totalRecords = projectMapper.countProjects(search);
        int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

        PageResponse<List<Project>> pageResponse = new PageResponse<>();
        pageResponse.setPageNo(pageNo);
        pageResponse.setPageSize(pageSize);
        pageResponse.setTotalPages(totalPages);
        pageResponse.setItems(projects);

        return pageResponse;
    }


    public ProjectResponseDTO createProject(Project project) {
        projectMapper.insert(project);

        return this.convertToDTO(project);
    }

    private ProjectResponseDTO convertToDTO(Project project) {
        ProjectResponseDTO responseDTO = new ProjectResponseDTO();
        responseDTO.setId(project.getId());
        responseDTO.setName(project.getName());
        responseDTO.setDifficulty(String.valueOf(project.getDifficulty()));
        responseDTO.setDept(project.getDepartment());
        return responseDTO;
    }
}
