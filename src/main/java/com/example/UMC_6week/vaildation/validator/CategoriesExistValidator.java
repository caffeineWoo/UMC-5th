package com.example.UMC_6week.vaildation.validator;


import com.example.UMC_6week.apiPayload.code.status.ErrorStatus;
import com.example.UMC_6week.repository.FoodCategoryRepository;
import com.example.UMC_6week.service.MemberCommandService;
import com.example.UMC_6week.service.MemberCommandServiceImpl;
import com.example.UMC_6week.vaildation.annotation.ExistCategories;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoriesExistValidator implements ConstraintValidator<ExistCategories, List<Long>> {

//    private final FoodCategoryRepository foodCategoryRepository;
    private final MemberCommandServiceImpl memberCommandServiceImpl;

    @Override
    public void initialize(ExistCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(List<Long> values, ConstraintValidatorContext context) {
//        boolean isValid = values.stream()
//                .allMatch(value -> foodCategoryRepository.existsById(value));
        boolean isValid = memberCommandServiceImpl.existById(values);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.FOOD_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}