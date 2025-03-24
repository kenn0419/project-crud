package com.kenn.project_crud.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectCreateDTO {
    @NotBlank(message = "Cannot be left blank")
    private String name;

    @NotNull(message = "Must not be empty")
    private Character difficulty;

    @NotNull(message = "Must not be empty")
    private Long dept;

    @NotNull(message = "Must not be empty")
    @Min(value = 1, message = "Minimum greater than 1")
    private Long version;

}
