package com.example.UMC_6week.apiPayload.exception.handler;

import com.example.UMC_6week.apiPayload.code.BaseErrorCode;
import com.example.UMC_6week.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}