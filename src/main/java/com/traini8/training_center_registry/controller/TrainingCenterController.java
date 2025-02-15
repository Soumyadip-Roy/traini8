package com.traini8.training_center_registry.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.traini8.training_center_registry.dto.TrainingCenterRequest;
import com.traini8.training_center_registry.dto.TrainingCenterResponse;
import com.traini8.training_center_registry.model.TrainingCenter;
import com.traini8.training_center_registry.service.TrainingCenterService;
import com.traini8.training_center_registry.mapper.TrainingCenterMapper;


@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;
    private final TrainingCenterMapper trainingCenterMapper;

    @Autowired
    public TrainingCenterController(TrainingCenterService trainingCenterService,
                                    TrainingCenterMapper trainingCenterMapper) {
        this.trainingCenterService = trainingCenterService;
        this.trainingCenterMapper = trainingCenterMapper;
    }

    // POST API: Create a new training center
    @PostMapping
    public ResponseEntity<TrainingCenterResponse> createTrainingCenter(
            @Valid @RequestBody TrainingCenterRequest request) {
        TrainingCenter createdCenter = trainingCenterService.createTrainingCenter(request);
        TrainingCenterResponse response = trainingCenterMapper.toResponseDto(createdCenter);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET API: Retrieve all training centers
//    @GetMapping
//    public ResponseEntity<List<TrainingCenterResponse>> getAllTrainingCenters() {
//        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
//        List<TrainingCenterResponse> responses = centers.stream()
//                .map(trainingCenterMapper::toResponseDto)
//                .collect(Collectors.toList());
//        return ResponseEntity.ok(responses);
//    }

    // GET API: Retrieve all training centers (with optional filters)
    @GetMapping
    public ResponseEntity<List<TrainingCenterResponse>> getTrainingCenters(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String course
    ) {
        List<TrainingCenter> centers = trainingCenterService.getTrainingCentersByFilters(city, state, course);

        List<TrainingCenterResponse> responses = centers.stream()
                .map(trainingCenterMapper::toResponseDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }
}
