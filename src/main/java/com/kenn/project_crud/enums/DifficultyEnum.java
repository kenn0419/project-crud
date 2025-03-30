package com.kenn.project_crud.enums;

import java.util.Arrays;

public enum DifficultyEnum {
    EASY,
    MEDIUM,
    HARD;

    public static boolean isValid(String value) {
        return Arrays.stream(DifficultyEnum.values())
                .anyMatch(difficulty -> difficulty.name().equals(value));
    }
}
