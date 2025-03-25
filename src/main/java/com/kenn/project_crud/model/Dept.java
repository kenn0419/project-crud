package com.kenn.project_crud.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class Dept implements Serializable {
    private Long id;
    private String name;
}
