package com.traini8.training_center_registry.dto;

import java.util.List;
import lombok.Data;

@Data
public class TrainingCenterRequest {
    private String centerName;
    private String centerCode;
    private AddressDto address;
    private Integer studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;
}
