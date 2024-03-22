package fairy.spring.fairy.home.repository;

import fairy.spring.fairy.home.entity.Category;

public interface CategoryRepository {
//        extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
