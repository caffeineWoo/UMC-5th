package com.example.UMC_6week.vaildation.validator;


import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.service.ReviewCommandServiceImpl;
import com.example.UMC_6week.service.StoreCommandServiceImpl;
import com.example.UMC_6week.vaildation.annotation.ExistStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewExistValidator implements ConstraintValidator<ExistStore, List<Long>> {


    private final ReviewCommandServiceImpl reviewCommandServiceImpl;

    @Override
    public void initialize(ExistStore constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {

        boolean isValid = reviewCommandServiceImpl.existById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}