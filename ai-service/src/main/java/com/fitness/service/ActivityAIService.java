package com.fitness.service;

import com.fitness.model.Activity;
import com.fitness.model.Recommendation;

public interface ActivityAIService {
    public Recommendation generateRecommendation(Activity activity);
}
