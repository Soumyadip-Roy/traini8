package com.traini8.training_center_registry.service;

import java.util.List;
import com.traini8.training_center_registry.dto.TrainingCenterRequest;
import com.traini8.training_center_registry.model.TrainingCenter;

public interface  TrainingCenterService {

    TrainingCenter createTrainingCenter(TrainingCenterRequest request);

    List<TrainingCenter> getAllTrainingCenters();


}
