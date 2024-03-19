package fairy.spring.fairy.home.repository;

import fairy.spring.fairy.home.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
