package fairy.spring.fairy.user.service;

import fairy.spring.fairy.config.auth.PrincipalUserDetails;
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



    @Transactional
    public MypageResponse.MypageinfoResponseDTO updateprofile(MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO){
        User user = userRepository.findByEmail(mypageinfoRequestDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found."));
        MypageInfo mypageInfo = mypageRepository.findByEmail(mypageinfoRequestDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found."));

        return new MypageResponse.MypageinfoResponseDTO(user.getNickname(),mypageInfo.getPoint(),mypageInfo.getGrade());
    }
}
