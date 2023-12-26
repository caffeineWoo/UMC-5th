package com.example.UMC_6week.apiPayload.exception.handler;

import com.example.UMC_6week.apiPayload.code.BaseErrorCode;
import com.example.UMC_6week.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}