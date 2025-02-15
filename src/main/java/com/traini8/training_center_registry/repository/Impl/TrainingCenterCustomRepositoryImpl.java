package com.traini8.training_center_registry.repository.Impl;

import com.traini8.training_center_registry.model.TrainingCenter;
import com.traini8.training_center_registry.repository.TrainingCenterCustomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainingCenterCustomRepositoryImpl implements TrainingCenterCustomRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public TrainingCenterCustomRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<TrainingCenter> findByFilters(String city, String state, String course) {
        Query query = new Query();
        List<Criteria> criteriaList = new ArrayList<>();

        if (city != null && !city.isEmpty()) {
            criteriaList.add(Criteria.where("address.city").is(city));
        }
        if (state != null && !state.isEmpty()) {
            criteriaList.add(Criteria.where("address.state").is(state));
        }
        if (course != null && !course.isEmpty()) {
            criteriaList.add(Criteria.where("coursesOffered").in(course));
        }

        if (!criteriaList.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteriaList.toArray(new Criteria[0])));
        }

        // Execute query => filter at database level
        return mongoTemplate.find(query, TrainingCenter.class);
    }
}