package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.user.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUserAndTip(String userId, Long tipId);
}