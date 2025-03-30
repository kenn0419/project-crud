package com.kenn.project_crud.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectQueryRequest {
    private String search;

    private int pageNo;

    private int pageSize;
}
