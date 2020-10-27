package com.example.chesspath.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CellValidator implements ConstraintValidator<ChessBoardCell, String> {
    public static final String REGEX = "[A-H][1-8]";

    private final Pattern pattern = Pattern.compile(REGEX);

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return pattern.matcher(value).matches();
        } catch (Exception e) {
            return false;
        }
    }

}
