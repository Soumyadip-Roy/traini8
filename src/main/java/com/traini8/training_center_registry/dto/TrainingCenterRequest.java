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

    public TrainingCenterRequest() {
    }

    public TrainingCenterRequest(String centerName, String centerCode, AddressDto address,
                                 Integer studentCapacity, List<String> coursesOffered,
                                 String contactEmail, String contactPhone) {
        this.centerName = centerName;
        this.centerCode = centerCode;
        this.address = address;
        this.studentCapacity = studentCapacity;
        this.coursesOffered = coursesOffered;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public Integer getStudentCapacity() {
        return studentCapacity;
    }

    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
