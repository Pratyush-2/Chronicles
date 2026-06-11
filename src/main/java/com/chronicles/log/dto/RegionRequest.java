package com.chronicles.log.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegionRequest {
    @NotBlank(message = "Region cannot be blank")
    @Size(max = 100,message = "Message cannot exceed 100 characters")
    private String name;

    @Size(max = 1000,message = "Description cannot exceed 1000 characters")
    private String description;
}
