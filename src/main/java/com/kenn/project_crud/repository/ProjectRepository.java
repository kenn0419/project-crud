//package com.kenn.project_crud.repository;
//
//import com.kenn.project_crud.model.Project;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface ProjectRepository extends JpaRepository<Project, Long> {
//    Project findByName(String name);
//
//    @Query("SELECT p FROM Project p FROM p.name LIKE :search OR p.difficulty LIKE :search")
//    Page<Project> findAll(@Param("search") String search, Pageable pageable);
//}
