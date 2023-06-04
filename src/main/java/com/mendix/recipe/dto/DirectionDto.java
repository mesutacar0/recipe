package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Direction Information for Recipe")
public class DirectionDto {

    @Schema(description = "Direction steps", example = "Stir, Cook etc.")
    private List<String> steps;

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public DirectionDto(List<String> steps) {
        this.steps = steps;
    }

}
