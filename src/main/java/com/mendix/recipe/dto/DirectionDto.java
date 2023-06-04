package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Direction Information for Recipe")
public class DirectionDto {

    @Schema(description = "Direction steps", example = "Stir, Cook etc.")
    private String step;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public DirectionDto(String step) {
        this.step = step;
    }

    public DirectionDto() {
    }

}
