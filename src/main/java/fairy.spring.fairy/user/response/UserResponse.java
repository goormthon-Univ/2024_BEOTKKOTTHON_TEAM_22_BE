package fairy.spring.fairy.user.response;

import lombok.Getter;
import lombok.Setter;

public class UserResponse {

        @Getter
        @Setter
        public static class SignupResponseDTO {
                String email;

                String password;

                String nickname;

                public SignupResponseDTO(String email, String password, String nickname) {
                        this.email = email;
                        this.password = password;
                        this.nickname = nickname;
                }

        }

        @Getter
        @Setter
        public static class LoginResponseWithTokenDTO {
                private LoginResponseDTO loginResponseDTO;
                private String token;

                public LoginResponseWithTokenDTO(LoginResponseDTO loginResponseDTO, String token) {
                        this.loginResponseDTO = loginResponseDTO;
                        this.token = token;
                }
        }

        @Getter
        @Setter
        public static class LoginResponseDTO {

                String email;

                String nickname;

                Long id;

                public LoginResponseDTO(String email, String nickname, Long id) {
                        this.email = email;
                        this.nickname = nickname;
                        this.id=id;
                }

        }


}
