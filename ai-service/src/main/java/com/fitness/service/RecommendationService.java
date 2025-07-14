package com.fitness.service;

import com.fitness.model.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getUserRecommendation(String userId);
    Recommendation getActivityRecommendation(String activityId);
}
