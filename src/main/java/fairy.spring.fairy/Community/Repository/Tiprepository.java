package fairy.spring.fairy.Community.Repository;

import fairy.spring.fairy.Community.domain.Tip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tiprepository extends JpaRepository<Tip, Long> {

}
