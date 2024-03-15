package fairy.spring.fairy.user.repository;

import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MypageRepository extends JpaRepository<MypageInfo, Long> {
    Optional<MypageInfo> findByEmail(String email);
}
