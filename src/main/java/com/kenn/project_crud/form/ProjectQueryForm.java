package com.kenn.project_crud.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectQueryForm {
    private String search;

    private int pageNo;

    private int pageSize;
}
