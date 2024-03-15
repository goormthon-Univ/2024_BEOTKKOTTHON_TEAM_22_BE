package fairy.spring.fairy.user.service;

import fairy.spring.fairy.config.auth.PrincipalUserDetails;
import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;

public class MypageService {

    private final UserRepository userRepository;

    public MypageService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public MypageResponse.MypageinfoResponseDTO updateprofile(MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO){
        User user = userRepository.findByEmail(mypageinfoRequestDTO.getEmail()).orElseThrow(() -> new RuntimeException("User not found."));
        MypageInfo mypageInfo = user.getMypageInfo();

        return new MypageResponse.MypageinfoResponseDTO(user.getNickname(),mypageInfo.getPoint(),mypageInfo.getGrade());
    }
}
