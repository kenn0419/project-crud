package com.kenn.project_crud.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResponse<T>{
    private int pageNo;
    private int pageSize;
    private int totalPages;
    private T items;
}
