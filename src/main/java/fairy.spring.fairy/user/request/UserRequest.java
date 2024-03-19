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
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @Component
    public static class SignupRequestDTO {
        @NotNull(message = "이메일은 필수 입력 값입니다.")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", message = "Invalid email format")
        private String email;

        @NotNull(message = "비밀번호는 필수 입력 값입니다.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be at least 8 characters long and include at least one letter and one number")
        private String password;

        @NotNull(message = "닉네임은 필수 입력 값입니다.")
        private String nickname;

        public User toEntity(RoleEnum role) {
            return User.builder()
                    .nickname(nickname)
                    .email(email)
                    .password(password)
                    .role(role)
                    .build();
        }

        public void setPassword(String encode) {
            this.password = encode;
        }
    }

    @NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    public static class BookmarkRequestDTO {
        private Long userId;
        private Long tipId;

        public BookmarkRequestDTO(Long userId, Long tipId) {
            this.userId = userId;
            this.tipId = tipId;
        }


    }
}



