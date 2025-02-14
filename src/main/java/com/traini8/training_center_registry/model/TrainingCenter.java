package com.traini8.training_center_registry.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "training_centers")
public class TrainingCenter {
    @Id
    private String id;
    private String centerName;
    private String centerCode;
    private Address address;
    private Integer studentCapacity;
    private List<String> coursesOffered;
    private Long createdOn;
    private String contactEmail;
    private String contactPhone;
}
