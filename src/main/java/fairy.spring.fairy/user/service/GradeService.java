package fairy.spring.fairy.user.service;

import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GradeService {
//    private final UserRepository userRepository;
    //포인트에 따른 등급 지정
//    @Transactional
    public void gradeup(Integer point, String email){
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new Exception400(null, "유저가 존재하지 않습니다."));
//         if (100 <= point && point < 500) {
//            user.setGrade("Level 2");
//        }else if (500 <= point && point < 1000) {
//            user.setGrade("Level 3");
//        }
//        else if (1000 <= point && point < 5000) {
//            user.setGrade("Level 4");
//        }
//        else if (5000 <= point && point < 10000) {
//            user.setGrade("Level 5");
//        }
//        else if (point >= 10000){
//            user.setGrade("Level 6");
//        }
//        userRepository.save(user);

    }
}
