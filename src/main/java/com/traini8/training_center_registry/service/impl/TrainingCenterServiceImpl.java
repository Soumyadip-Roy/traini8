package com.traini8.training_center_registry.service.impl;

import java.util.List;

import com.traini8.training_center_registry.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.traini8.training_center_registry.dto.TrainingCenterRequest;
import com.traini8.training_center_registry.model.Address;
import com.traini8.training_center_registry.model.TrainingCenter;
import com.traini8.training_center_registry.repository.TrainingCenterRepository;
import com.traini8.training_center_registry.service.TrainingCenterService;

@Service
public class TrainingCenterServiceImpl implements TrainingCenterService {

    private final TrainingCenterRepository trainingCenterRepository;
    @Autowired
    public TrainingCenterServiceImpl(TrainingCenterRepository trainingCenterRepository) {
        this.trainingCenterRepository = trainingCenterRepository;

    }

    @Override
    public TrainingCenter createTrainingCenter(TrainingCenterRequest request) {
        if (trainingCenterRepository.existsByCenterCode(request.getCenterCode())) {
//            throw new ValidationException("Center code already exists");
        }

        TrainingCenter trainingCenter = new TrainingCenter();

        trainingCenter.setCenterName(request.getCenterName());
        trainingCenter.setCenterCode(request.getCenterCode());

        //
        Address address = new Address();
        address.setDetailedAddress(request.getAddress().getDetailedAddress());
        address.setCity(request.getAddress().getCity());
        address.setState(request.getAddress().getState());
        address.setPincode(request.getAddress().getPincode());
        trainingCenter.setAddress(address);
        //
        trainingCenter.setStudentCapacity(request.getStudentCapacity());
        trainingCenter.setCoursesOffered(request.getCoursesOffered());

        // createdOn field is set by the server
        // trainingCenter.setCreatedOn(System.currentTimeMillis());
        // createdOn will be auto-populated

        trainingCenter.setContactEmail(request.getContactEmail());
        trainingCenter.setContactPhone(request.getContactPhone());

        // Save the training center
        TrainingCenter x = trainingCenterRepository.save(trainingCenter);
        System.out.println("saved");
        return x;
    }

    @Override
    public List<TrainingCenter> getAllTrainingCenters() {
        // Retrieve all training centers from the DB
        return trainingCenterRepository.findAll();
    }
}
