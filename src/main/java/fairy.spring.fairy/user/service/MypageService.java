package fairy.spring.fairy.user.service;


import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.config.jwt.JwtAuthenticationFilter;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MypageService {

    private final UserRepository userRepository;
    private final GradeService gradeService;



    //프로필 조회

    @Transactional
    public MypageResponse.MypageinfoResponseDTO updateprofile(MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO){
        User user = userRepository.findByEmail(mypageinfoRequestDTO.getEmail()).orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        gradeService.gradeup(user.getTotalpoint(),mypageinfoRequestDTO.getEmail());
        return new MypageResponse.MypageinfoResponseDTO(user.getNickname(),user.getTotalpoint(),user.getGrade());
    }
}
