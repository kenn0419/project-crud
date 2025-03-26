package com.kenn.project_crud.logic;

import com.kenn.project_crud.dto.request.ProjectCreateDTO;
import com.kenn.project_crud.dto.response.ProjectResponseDTO;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.service.ProjectService;
import com.kenn.project_crud.service.impl.ProjectApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Component
@RequiredArgsConstructor
public class ProjectLogic {
    private final ProjectApiService projectService;

    public void validate(ProjectCreateDTO request, BindingResult bindingResult) {
        if (request.getName() == null || request.getName().isEmpty()) {
            bindingResult.rejectValue("name", "error.name", "Project name can not be blank");
        }
        //....
    }

    public Project convertToEntity(ProjectCreateDTO request) {
        Project project = new Project();
        project.setName(request.getName());
        project.setDifficulty(request.getDifficulty());
        project.setVersion(request.getVersion());
        project.getDept().setId(request.getDept());

        return project;
    }

    public ProjectResponseDTO processRegisterProject(ProjectCreateDTO request, BindingResult bindingResult, ProjectApiService projectService) {
        validate(request, bindingResult);
        if (bindingResult.hasErrors()) {
            return null;
        }

        Project project = convertToEntity(request);

        return this.projectService.createProject(project);
    }
}
