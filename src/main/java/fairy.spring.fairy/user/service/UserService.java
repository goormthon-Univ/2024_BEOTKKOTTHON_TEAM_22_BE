package fairy.spring.fairy.user.service;


import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.config.jwt.TokenProvider;
import fairy.spring.fairy.user.domain.RoleEnum;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.UserRequest;
import fairy.spring.fairy.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;


//    @Transactional(readOnly = true)
    public UserResponse.LoginResponseWithTokenDTO login(UserRequest.LoginRequestDTO request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new Exception400(null, "회원가입을 해주세요."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new Exception400(null, "아이디 또는 비밀번호가 일치하지 않습니다.");
        }

        String token = tokenProvider.createToken(user.getEmail());

        UserResponse.LoginResponseDTO loginResponseDTO = new UserResponse.LoginResponseDTO(user.getEmail(), user.getNickname(),  user.getId());

        return new UserResponse.LoginResponseWithTokenDTO(loginResponseDTO, token);
    }

//    @Transactional
    public void signup(UserRequest.SignupRequestDTO requestDTO) {
        if(userRepository.existsByEmail(requestDTO.getEmail())){
           throw new Exception400(null,"이미 가입된 사용자가 있습니다.");
        }
        // 비밀번호 암호화
        requestDTO.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        requestDTO.setTotalpoint(0);
        requestDTO.setGrade("Level 1");

        User newUser =requestDTO.toEntity(RoleEnum.USER);


        // 저장
//        userRepository.save(newUser);


    }
}
