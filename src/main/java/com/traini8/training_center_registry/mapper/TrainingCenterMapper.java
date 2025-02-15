package com.traini8.training_center_registry.mapper;

import com.traini8.training_center_registry.dto.AddressDto;
import com.traini8.training_center_registry.dto.TrainingCenterResponse;
import com.traini8.training_center_registry.model.Address;
import com.traini8.training_center_registry.model.TrainingCenter;
import org.springframework.stereotype.Component;

@Component
public class TrainingCenterMapper {

    public TrainingCenterResponse toResponseDto(TrainingCenter trainingCenter) {
        if (trainingCenter == null) {
            return null;
        }

        TrainingCenterResponse response = new TrainingCenterResponse();
        response.setId(trainingCenter.getId());
        response.setCenterName(trainingCenter.getCenterName());
        response.setCenterCode(trainingCenter.getCenterCode());
        response.setStudentCapacity(trainingCenter.getStudentCapacity());
        response.setCoursesOffered(trainingCenter.getCoursesOffered());
        // Instant to ISO-8601 string
        if (trainingCenter.getCreatedOn() != null) {
            response.setCreatedOn(trainingCenter.getCreatedOn().toString());
        }
        response.setContactEmail(trainingCenter.getContactEmail());
        response.setContactPhone(trainingCenter.getContactPhone());

        Address address = trainingCenter.getAddress();
        if (address != null) {
            AddressDto addressDto = new AddressDto();
            addressDto.setDetailedAddress(address.getDetailedAddress());
            addressDto.setCity(address.getCity());
            addressDto.setState(address.getState());
            addressDto.setPincode(address.getPincode());
            response.setAddress(addressDto);
        }

        return response;
    }
}