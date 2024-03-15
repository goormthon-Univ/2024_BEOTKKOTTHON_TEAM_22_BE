package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.config.auth.PrincipalUserDetails;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Tag(name="mypage", description = "마이페이지 api")
@RequestMapping("/api")
@Controller
@RequiredArgsConstructor
public class MypageController {
    @Autowired
    private UserRepository userRepository;

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/user")
    public String userInfo(PrincipalUserDetails principalUserDetails)

}
