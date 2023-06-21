package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Ingredient", description = "Recipe Ingredient Information")
public class IngredientDto {

    @NotNull(message = "Ingredient amount cannot be null")
    @Valid
    private IngredientAmountDto amount;
    @Schema(description = "Ingredient item name", example = "Egg, Sugar etc.")
    @NotEmpty(message = "Ingredient item is mandatory")
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

}
