package fairy.spring.fairy.user.request;



import fairy.spring.fairy.user.domain.RoleEnum;
import fairy.spring.fairy.user.domain.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


public class UserRequest {

    @Getter
    @NoArgsConstructor
    @Component
    public static class SignupRequestDTO {
        @NotNull(message = "이메일은 필수 입력 값입니다.")
        @Setter
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
        private String email;

        @Setter
        @NotNull(message = "비밀번호는 필수 입력 값입니다.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and include at least one letter and one number")
        private String password;

        @Setter
        @NotNull(message = "닉네임은 필수 입력 값입니다.")
        private String nickname;

        @Setter
        private Integer totalpoint;

        @Setter
        private String grade;

        @Setter
        private String profileurl;

        public User toEntity(RoleEnum role) {
            return User.builder()
                    .nickname(nickname)
                    .email(email)
                    .password(password)
                    .role(role)
                    .totalpoint(totalpoint)
                    .grade(grade)
                    .profileimage(profileurl)
                    .build();
        }

    }

    @NoArgsConstructor
    @Getter
    public static class LoginRequestDTO {
        @NotNull(message = "이메일은 필수 입력 값입니다.")
        private String email;

        @NotNull(message = "비밀번호는 필수 입력 값입니다.")
        private String password;

        public LoginRequestDTO(String email, String password) {
            this.email = email;
            this.password = password;
        }
    }




    }




