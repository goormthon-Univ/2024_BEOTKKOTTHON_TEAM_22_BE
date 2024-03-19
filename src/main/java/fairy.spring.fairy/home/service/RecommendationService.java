package fairy.spring.fairy.home.service;

import fairy.spring.fairy.home.entity.Recommendation;

import java.util.List;

public interface RecommendationService {
    List<Recommendation> getAllRecommendations();
    Recommendation getRecommendationById(Long id);
}