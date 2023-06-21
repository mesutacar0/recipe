package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(name = "Ingredient Amount", description = "Recipe Ingredient Amount  Information")
public class IngredientAmountDto {

    @Schema(description = "Amount Quantity", example = "1, 1/2 etc.")
    @NotEmpty(message = "Amount quantity is mandatory")
    private String quantity;
    @Schema(description = "Amount Unit", example = "cups, package, tablespoon etc.")
    private String unit;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
