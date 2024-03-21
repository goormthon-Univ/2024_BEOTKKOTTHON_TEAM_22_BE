package fairy.spring.fairy.Community.Repository;

import fairy.spring.fairy.Community.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Commentrepository extends JpaRepository<Comment, Long> {
}
