package com.kenn.project_crud.logic;

import com.kenn.project_crud.dto.request.ProjectCreateDTO;
import com.kenn.project_crud.dto.request.ProjectQueryRequest;
import com.kenn.project_crud.dto.response.PageResponse;
import com.kenn.project_crud.dto.response.ProjectResponseDTO;
import com.kenn.project_crud.enums.DifficultyEnum;
import com.kenn.project_crud.form.ProjectCreateForm;
import com.kenn.project_crud.form.ProjectQueryForm;
import com.kenn.project_crud.model.Project;
import com.kenn.project_crud.service.ProjectService;
import com.kenn.project_crud.service.impl.ProjectApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.yaml.snakeyaml.util.EnumUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProjectLogic {
    private final ProjectApiService projectService;

    public void validateProjectCreateForm(ProjectCreateForm form, BindingResult bindingResult) {
        public void validateProjectCreateDTO(ProjectCreateDTO form, BindingResult bindingResult) {
            // Check name không được rỗng
            if (form.getName() == null || form.getName().trim().isEmpty()) {
                bindingResult.rejectValue("name", "name.empty", "Tên dự án không được để trống.");
            } else if (projectRepository.existsByName(form.getName())) {
                bindingResult.rejectValue("name", "name.exists", "Tên dự án đã tồn tại.");
            }

            // Check difficulty có trong enum không
            if (form.getDifficulty() == null || !DifficultyEnum.isValid(form.getDifficulty())) {
                bindingResult.rejectValue("difficulty", "difficulty.invalid", "Độ khó phải là EASY, MEDIUM hoặc HARD.");
            }

            // Check dept có tồn tại trong database không
            if (form.getDept() == null || !deptRepository.existsByName(form.getDept())) {
                bindingResult.rejectValue("dept", "dept.invalid", "Phòng ban không tồn tại.");
            }
        }
    }

    public void validateProjectQueryForm(ProjectQueryForm projectQueryForm, BindingResult bindingResult) {
        if (projectQueryForm.getSearch() != null && !projectQueryForm.getSearch().matches("^[a-zA-Z0-9 ]*$")) {
            if (bindingResult != null) {
                bindingResult.rejectValue("search", "invalid.search", "Search contains invalid characters.");
            } else {
                throw new IllegalArgumentException("Search contains invalid characters.");
            }
        }
        if (projectQueryForm.getPageNo() < 0 || projectQueryForm.getPageSize() <= 0) {
            if (bindingResult != null) {
                bindingResult.rejectValue("pageNo", "invalid.pageNo", "Page number and size must be positive.");
            } else {
                throw new IllegalArgumentException("Page number and size must be positive.");
            }
        }
    }

    public ProjectQueryRequest convertToProjectQueryRequest(ProjectQueryForm projectQueryForm) {
        ProjectQueryRequest projectQueryRequest = new ProjectQueryRequest();

        projectQueryRequest.setSearch(projectQueryForm.getSearch());
        projectQueryRequest.setPageSize(projectQueryForm.getPageNo());
        projectQueryRequest.setPageSize(projectQueryForm.getPageSize());

        return projectQueryRequest;
    }

    public ProjectQueryRequest toProjectQueryRequest(ProjectQueryForm projectQueryForm) {
        ProjectQueryRequest projectQueryRequest = new ProjectQueryRequest();
        projectQueryRequest.setSearch(projectQueryForm.getSearch());
        projectQueryRequest.setPageNo(projectQueryForm.getPageNo());
        projectQueryRequest.setPageSize(projectQueryForm.getPageSize());

        return projectQueryRequest;
    }

    public PageResponse<List<ProjectResponseDTO>> processGetProjects(ProjectQueryForm projectQueryForm) {

        ProjectQueryRequest projectQueryRequest = toProjectQueryRequest(projectQueryForm);

        return this.projectService.getProjects(projectQueryRequest);
    }

//    public ProjectResponseDTO processRegisterProject(ProjectCreateDTO request, BindingResult bindingResult, ProjectApiService projectService) {
//        validate(request, bindingResult);
//        if (bindingResult.hasErrors()) {
//            return null;
//        }
//
//        Project project = convertToEntity(request);
//
//        return this.projectService.createProject(project);
//    }
}
