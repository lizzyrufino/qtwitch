package dev.api.common.validator;

import dev.api.common.annotations.RequiredEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class EnumValidator implements ConstraintValidator<RequiredEnum, String> {

    private List<String> values;
    private String messageKey;

    @Override
    public void initialize(RequiredEnum annotation) {
        this.values = Arrays
                .stream(annotation.enumClass().getEnumConstants())
                .map(Enum::name).toList();

        this.messageKey = annotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value) || values.contains(value)) return true;

        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(messageKey)
                .addConstraintViolation();

        return false;
    }
}
