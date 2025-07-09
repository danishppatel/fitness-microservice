package com.fitness.service;

import com.fitness.dto.ActivityRequest;
import com.fitness.dto.ActivityResponse;

import java.util.List;

public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest activityRequest);
    List<ActivityResponse> getUserActivitiesById(String userId);
    ActivityResponse getActivitiyById(String activityId);
}
