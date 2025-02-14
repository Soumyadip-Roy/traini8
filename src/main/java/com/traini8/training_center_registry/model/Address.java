package com.traini8.training_center_registry.model;

import lombok.Data;

@Data
public class Address {
    private String detailedAddress;
    private String city;
    private String state;
    private String pincode;
}