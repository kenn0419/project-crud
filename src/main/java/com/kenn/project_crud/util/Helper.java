//package com.kenn.project_crud.util;
//
//import com.kenn.project_crud.dto.request.ProjectCreateDTO;
//import com.kenn.project_crud.dto.request.ProjectUpdateDTO;
//import com.kenn.project_crud.model.Project;
//
//public class Helper {
//    public static Project toProject(ProjectCreateDTO request) {
//        Project project = new Project();
//        project.setName(request.getName());
//        project.setDifficulty(request.getDifficulty());
//        project.setVersion(request.getVersion());
//
//        return project;
//    }
//
//    public static Project toProject(Project project, ProjectUpdateDTO request) {
//        project.setName(request.getName());
//        project.setDifficulty(request.getDifficulty());
//        project.setVersion(request.getVersion());
//
//        return project;
//    }
//
//    public static ProjectUpdateDTO toProjectUpdateDTO(Project project) {
//        ProjectUpdateDTO projectUpdateDTO = new ProjectUpdateDTO();
//        projectUpdateDTO.setId(project.getId());
//        projectUpdateDTO.setName(project.getName());
//        projectUpdateDTO.setDifficulty(project.getDifficulty());
//        projectUpdateDTO.setVersion(project.getVersion());
//        projectUpdateDTO.setDept(project.getDept().getId());
//
//        return projectUpdateDTO;
//    }
//}
