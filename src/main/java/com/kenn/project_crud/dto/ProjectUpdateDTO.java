package com.kenn.project_crud.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProjectUpdateDTO {
    private Long id;

    private String name;

    private Character difficulty;

    private Long dept;

    private Long version;

}
