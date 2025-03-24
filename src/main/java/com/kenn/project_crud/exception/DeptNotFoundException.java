package com.kenn.project_crud.exception;

public class DeptNotFoundException extends RuntimeException{
    public DeptNotFoundException(String message) {
        super(message);
    }
}
