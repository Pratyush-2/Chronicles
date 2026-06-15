package com.chronicles.log.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LeaderRequest {
    @NotNull(message = "Leader name cannot be blank")
    private String name;
    private String title;
    private String description;
    private Integer birthYear;
    private Integer deathYear;
    @NotNull(message = "CivilizationID cannot be blank")
    private Long civilizationId;


}
