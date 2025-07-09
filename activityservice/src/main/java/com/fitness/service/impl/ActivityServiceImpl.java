package com.fitness.service.impl;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;
import com.fitness.mapper.ActivityMapper;
import com.fitness.model.Activity;
import com.fitness.repository.ActivityRepository;
import com.fitness.service.ActivityService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    @Override
    public ActivityResponse trackActivity(ActivityRequest request) {
        Activity activity = Activity.builder()
                .userId(request.getUserId())
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity = activityRepository.save(activity);

        return ActivityMapper.mapToDto(savedActivity);
    }

    @Override
    public List<ActivityResponse> getUserActivitiesById(String userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);

        return activities.stream()
                .map((ActivityMapper::mapToDto))
                .collect(Collectors.toList());
    }

    @Override
    public ActivityResponse getActivitiyById(String activityId) {
        return activityRepository.findById(activityId)
                .map(ActivityMapper::mapToDto)
                .orElseThrow(() -> new RuntimeException("Activity not found with id : "+ activityId));
    }
}
