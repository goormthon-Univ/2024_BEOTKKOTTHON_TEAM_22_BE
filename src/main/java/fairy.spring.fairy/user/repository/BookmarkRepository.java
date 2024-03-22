package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.domain.User;

public interface BookmarkRepository {
//    extends JpaRepository<Bookmark, Long> {
    Bookmark findByUserAndTip(User user, Tip tip);
}
