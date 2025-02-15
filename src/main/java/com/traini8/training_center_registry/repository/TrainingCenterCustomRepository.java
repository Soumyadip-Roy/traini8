package com.traini8.training_center_registry.repository;

import com.traini8.training_center_registry.model.TrainingCenter;
import java.util.List;

public interface TrainingCenterCustomRepository {
    // custom method to filter at database level
    List<TrainingCenter> findByFilters(String city, String state, String course);
}