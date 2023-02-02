package edu.escuelait.tienda.validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CUITValidator implements ConstraintValidator<Cuit, String> {

 @Override
 public boolean isValid(String value, ConstraintValidatorContext context) {

    if (value == null) {
       return false;
    }

    return value.length()==13;
 }

}

