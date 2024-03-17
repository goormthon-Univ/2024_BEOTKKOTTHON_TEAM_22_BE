package fairy.spring.fairy.Community.Repository;

import fairy.spring.fairy.Community.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface questionrepository extends JpaRepository<Question, Long> {

}
