package fairy.spring.fairy.user.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserResponse {

        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class SignupResponseDTO {
                @Schema(description = "이메일", example = "example@example.com")
                String email;
                @Schema(description = "비밀번호", example = "$2a$10$5X9R/f1lQCKyzVxwswZqJOaOagB8zR5TOJi/63npMa6JTqVgr5iwq\n")
                String password;
                @Schema(description = "닉네임", example = "chee0630")
                String nickname;

                public SignupResponseDTO(String email, String password, String nickname) {
                        this.email = email;
                        this.password = password;
                        this.nickname = nickname;
                }

        }

        @Getter
        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class LoginResponseWithTokenDTO {
                @Schema(description = "로그인 응답", implementation = LoginResponseDTO.class)
                private LoginResponseDTO loginResponseDTO;
                @Schema(description = "JWT 토큰", example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjaG9ib3NzMDAiLCJpYXQiOjE2MzIwNzIwMzMsImV4cCI6MTYzMjA3NTYzM30.")
                private String token;

                public LoginResponseWithTokenDTO(LoginResponseDTO loginResponseDTO, String token) {
                        this.loginResponseDTO = loginResponseDTO;
                        this.token = token;
                }
        }

        @Getter
//        @NoArgsConstructor(access = AccessLevel.PROTECTED)
        public static class LoginResponseDTO {
                @Schema(description = "회원 이메일", example = "example@example.com")
                String email;
                @Schema(description = "회원 닉네임", example = "chee0630")
                String nickname;
                @Schema(description = "유저 아이디")
                Long id;


                public LoginResponseDTO(String email, String nickname, Long id) {
                        this.email = email;
                        this.nickname = nickname;
                        this.id=id;

                }

        }


}
