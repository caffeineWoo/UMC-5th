package com.example.UMC_6week.web.dto;

import com.example.UMC_6week.vaildation.annotation.ExistCategories;
import com.example.UMC_6week.web.entity.Region;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDto{
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @NotNull
        Float score;
        @NotNull
        Region region;
    }
}