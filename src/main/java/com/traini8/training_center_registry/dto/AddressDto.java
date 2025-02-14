package com.traini8.training_center_registry.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}
