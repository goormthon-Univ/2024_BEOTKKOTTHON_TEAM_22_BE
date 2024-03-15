package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.user.domain.Todolist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todolist, Long> {
}
