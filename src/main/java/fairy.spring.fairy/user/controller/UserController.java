package fairy.spring.fairy.user.controller;


import fairy.spring.fairy.config.jwt.TokenProvider;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.UserRequest;
import fairy.spring.fairy.user.response.UserResponse;
import fairy.spring.fairy.user.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Tag(name = "User", description = "유저 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid UserRequest.SignupRequestDTO requestDTO, Errors errors) {
        userService.signup(requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid UserRequest.LoginRequestDTO requestDTO, Errors errors, HttpServletResponse response) {
        //TO-DO : 로그인 로직 구현하기
        UserResponse.LoginResponseWithTokenDTO loginDTO = userService.login(requestDTO);

        String accessToken = TokenProvider.TOKEN_PREFIX + loginDTO.getToken();

        // jwt 헤더에 담기
        response.setHeader(HttpHeaders.AUTHORIZATION, accessToken);

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(loginDTO.getLoginResponseDTO()));
    }

}