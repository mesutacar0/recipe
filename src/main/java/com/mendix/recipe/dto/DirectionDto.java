package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(name = "Direction", description = "Direction Information for Recipe")
public class DirectionDto {

    @Schema(description = "Direction steps", example = "Stir, Cook etc.")
    @NotEmpty(message = "Direction step is mandatory")
    private String step;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

}
