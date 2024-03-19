package fairy.spring.fairy.home.repository;

import fairy.spring.fairy.home.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);
}