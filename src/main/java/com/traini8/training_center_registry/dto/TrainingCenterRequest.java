package com.traini8.training_center_registry.dto;

import java.util.List;
import lombok.Data;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@Data
public class TrainingCenterRequest {
    @NotBlank(message = "Center name is required")
    @Size(max = 40, message = "Center name must be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center code is required")
    @Size(min = 12, max = 12, message = "Center code must be exactly 12 characters")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Center code must be alphanumeric")
    private String centerCode;

    @NotNull(message = "Address is required")
    @Valid
    private AddressDto address;

    @Min(value = 1, message = "Student capacity must be at least 1")
    private Integer studentCapacity;

    private List<@NotBlank(message = "Course name cannot be blank") String> coursesOffered;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact phone is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be a valid 10 digit number")
    private String contactPhone;

    // lombok.Data NOT working - remove later after debugging

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
