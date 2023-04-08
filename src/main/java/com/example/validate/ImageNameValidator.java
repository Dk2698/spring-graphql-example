package com.example.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;

public class ImageNameValidator  implements ConstraintValidator<ImageNameValid, String> {

    private Logger logger = LoggerFactory.getLogger(ImageNameValidator.class);
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        logger.info("message from invalid :{}", value);
        // logic
        if (value.isBlank()) {
            return false;
        } else {
            return true;
        }

    }
}
