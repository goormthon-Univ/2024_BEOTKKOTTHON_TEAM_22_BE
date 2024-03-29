package fairy.spring.fairy.home.service.impl;

import fairy.spring.fairy.home.entity.Recommendation;
import fairy.spring.fairy.home.repository.RecommendationRepository;
import fairy.spring.fairy.home.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;

    @Override
    public List<Recommendation> getAllRecommendations() {
        return recommendationRepository.findAll();
    }

    @Override
    public Recommendation getRecommendationById(Long id) {
        return recommendationRepository.findById(id).orElse(null);
    }
}