package com.traini8.training_center_registry.dto;

import java.util.List;
import lombok.Data;

@Data
public class TrainingCenterResponse {
    private String id;
    private String centerName;
    private String centerCode;
    private AddressDto address;
    private Integer studentCapacity;
    private List<String> coursesOffered;
    private Long createdOn;
    private String contactEmail;
    private String contactPhone;
}

