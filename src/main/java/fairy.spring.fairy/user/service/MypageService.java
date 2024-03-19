package fairy.spring.fairy.user.service;


import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.MypageRepository;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MypageService {

    private final UserRepository userRepository;
    private final MypageRepository mypageRepository;


    //프로필 조회
    @Transactional
    public MypageResponse.MypageinfoResponseDTO updateprofile(MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO){
        User user = userRepository.findByEmail(mypageinfoRequestDTO.getEmail()).orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        MypageInfo mypageInfo = MypageInfo.builder()
                .email(user.getEmail())
                .grade(mypageinfoRequestDTO.getGrade())
                .point(mypageinfoRequestDTO.getTotalpoint())
                .build();
        mypageInfo = mypageRepository.save(mypageInfo);
        return new MypageResponse.MypageinfoResponseDTO(user.getNickname(),mypageInfo.getPoint(),mypageInfo.getGrade());
    }
}
