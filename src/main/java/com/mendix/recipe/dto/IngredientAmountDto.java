package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Ingredient Amount  Information")
public class IngredientAmountDto {
    @Schema(description = "Amount Quantity", example = "1, 1/2 etc.")
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

    public IngredientAmountDto(String quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }
}
