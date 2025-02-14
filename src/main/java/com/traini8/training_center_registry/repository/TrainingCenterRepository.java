package com.traini8.training_center_registry.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.traini8.training_center_registry.model.TrainingCenter;

@Repository
public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, String> {
}