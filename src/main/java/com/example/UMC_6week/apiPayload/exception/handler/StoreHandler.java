package com.example.UMC_6week.apiPayload.exception.handler;


import com.example.UMC_6week.apiPayload.code.BaseErrorCode;
import com.example.UMC_6week.apiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}