package com.example.UMC_6week.vaildation.annotation;


import com.example.UMC_6week.vaildation.validator.CategoriesExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.tlqkfRJ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}