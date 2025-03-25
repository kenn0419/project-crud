package com.kenn.project_crud.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class Project implements Serializable {
    private Long id;
    private String name;
    private Character difficulty;
    private Long version;
    private LocalDate insertTime;
    private LocalDate updateTime;
    private Dept dept;
}
