package fairy.spring.fairy.home.repository;

import fairy.spring.fairy.home.entity.Category;
import fairy.spring.fairy.home.entity.Tip;

import java.util.List;

public interface TipRepository {
//        extends JpaRepository<Tip, Long> {
    List<Tip> findByCategory(Category category);
    List<Tip> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);
}
