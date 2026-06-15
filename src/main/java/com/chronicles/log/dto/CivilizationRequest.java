package com.chronicles.log.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CivilizationRequest {
    @NotBlank(message = "Civilization name cannot be blank")
    private String name;
    private Integer foundedYear;
    private Integer collapsedYear;
    private String description;
    @NotNull(message = "Region ID cannot be blank")
    private Long regionId;
}
