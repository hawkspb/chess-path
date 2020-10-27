package com.example.chesspath.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = CellValidator.class)
@Documented
public @interface ChessBoardCell {

    String message() default "Cell format invalid";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}