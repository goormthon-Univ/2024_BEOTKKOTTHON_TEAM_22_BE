package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    Bookmark findByTipid(Long tipid);
    Bookmark findByQuestionid(Long questionid);
}
