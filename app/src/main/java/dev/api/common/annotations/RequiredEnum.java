package dev.api.common.annotations;

import dev.api.common.validator.EnumValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = EnumValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredEnum {

    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid enumerated values.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
