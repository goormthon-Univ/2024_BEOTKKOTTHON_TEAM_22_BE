package fairy.spring.fairy.Community.Repository;

import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.user.domain.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionrepository extends JpaRepository<Question, Long> {

}
