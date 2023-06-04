package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Ingredient Information")
public class IngredientDto {
    private IngredientAmountDto amount;
    @Schema(description = "Ingredient item name", example = "Egg, Sugar etc.")
    private String item;

    public IngredientAmountDto getAmount() {
        return amount;
    }

    public void setAmount(IngredientAmountDto amount) {
        this.amount = amount;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public IngredientDto(IngredientAmountDto amount, String item) {
        this.amount = amount;
        this.item = item;
    }
}
