package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.user.domain.Checklist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository {
//        extends JpaRepository<Checklist, Long> {
    List<Checklist> findByUserid(Long userid);
}
