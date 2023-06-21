package com.mendix.recipe.dto.validation;

import com.mendix.recipe.dto.IngredientWrapperDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IngredientWrapperValidator
        implements ConstraintValidator<IngredientWrapperValidation, IngredientWrapperDto> {

    @Override
    public boolean isValid(IngredientWrapperDto ingredientWrapper, ConstraintValidatorContext ctx) {
        return ingredientWrapper != null
                && !(ingredientWrapper.getIngredientDivs().isEmpty() && ingredientWrapper.getIngredients().isEmpty());
    }
}
