package dev.api.commom.validator;

import dev.api.commom.annotations.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<Email, String> {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if(Objects.isNull(email) || email.trim().isEmpty()){
            return false;
        }
        return pattern.matcher(email).matches();
    }
}
