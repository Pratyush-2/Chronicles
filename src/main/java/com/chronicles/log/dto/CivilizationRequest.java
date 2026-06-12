package com.chronicles.log.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CivilizationRequest {
    @NotBlank
    private String Name;
    private Integer foundedYear;
    private Integer collapsedYear;
    private String description;
    @NotNull
    private Long regionId;
}
