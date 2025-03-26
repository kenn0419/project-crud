package com.kenn.project_crud.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectResponseDTO {
    private Long id;

    private String name;

    private String difficulty;

    private String dept;

    private Long version;
}
