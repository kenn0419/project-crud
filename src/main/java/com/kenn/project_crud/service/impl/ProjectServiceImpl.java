//package com.kenn.project_crud.service.impl;
//
//import com.kenn.project_crud.dto.request.ProjectCreateDTO;
//import com.kenn.project_crud.dto.request.ProjectUpdateDTO;
//import com.kenn.project_crud.dto.response.PageResponse;
//import com.kenn.project_crud.exception.DeptNotFoundException;
//import com.kenn.project_crud.exception.ProjectNotFoundException;
//import com.kenn.project_crud.model.Dept;
//import com.kenn.project_crud.model.Project;
//import com.kenn.project_crud.model.User;
//import com.kenn.project_crud.repository.DeptRepository;
//import com.kenn.project_crud.repository.ProjectRepository;
//import com.kenn.project_crud.service.ProjectService;
//import com.kenn.project_crud.util.Helper;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProjectServiceImpl implements ProjectService {
//    private final ProjectRepository projectRepository;
//    private final DeptRepository deptRepository;
//
//    public ProjectServiceImpl(ProjectRepository projectRepository, DeptRepository deptRepository) {
//        this.projectRepository = projectRepository;
//        this.deptRepository = deptRepository;
//    }
//
//    @Override
//    public void createProject(ProjectCreateDTO request) {
////        Project existProject = this.projectRepository.findByName(request.getName());
////        if (existProject != null) {
////            throw new ProjectNotFoundException("Existed project with this project name");
////        }
////        Optional<Dept> existDept = this.deptRepository.findById(request.getDept());
////        if (existDept.isEmpty()) {
////            throw new DeptNotFoundException("Not existed department with this id");
////        }
////
////        Project newProject = Helper.toProject(request);
////        newProject.setDept(existDept.get());
////
////        this.projectRepository.save(newProject);
//    }
//
//    @Override
//    public PageResponse<List<Project>> getProjects(String search, int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by("id"));
//        search = "%" + search + "%";
//
//        Page<Project> projectPage = this.projectRepository.findAll(search, pageable);
//
//        PageResponse<List<Project>> pageResponse = new PageResponse<>();
//        pageResponse.setPageNo(pageNo);
//        pageResponse.setPageSize(pageSize);
//        pageResponse.setTotalPages(projectPage.getTotalPages());
//        pageResponse.setItems(projectPage.getContent());
//
//        return pageResponse;
//    }
//
//    @Override
//    public Project getProjectById(Long projectId) {
//        return this.projectRepository.findById(projectId)
//                .orElseThrow(() -> new ProjectNotFoundException("Not existed project with this id"));
//    }
//
//    @Override
//    public void updateProject(ProjectUpdateDTO request) {
//        Project updateProject = this.getProjectById(request.getId());
//        Optional<Dept> existDept = this.deptRepository.findById(request.getDept());
//        if (existDept.isEmpty()) {
//            throw new DeptNotFoundException("Not existed department with this id");
//        }
//        Helper.toProject(updateProject, request);
//        updateProject.setDept(existDept.get());
//
//        this.projectRepository.save(updateProject);
//    }
//
//    @Override
//    public void deleteProject(Long projectId) {
//        Project deleteProject = this.getProjectById(projectId);
//        this.projectRepository.delete(deleteProject);
//    }
//}
