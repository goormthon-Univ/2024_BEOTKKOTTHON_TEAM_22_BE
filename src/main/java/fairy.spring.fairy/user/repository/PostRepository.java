package fairy.spring.fairy.user.repository;


import fairy.spring.fairy.Community.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Question, Long> {

}

