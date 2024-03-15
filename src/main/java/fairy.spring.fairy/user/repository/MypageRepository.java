package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MypageRepository extends JpaRepository<MypageInfo, Long> {
    Optional<MypageInfo> findByEmail(String email);
}
