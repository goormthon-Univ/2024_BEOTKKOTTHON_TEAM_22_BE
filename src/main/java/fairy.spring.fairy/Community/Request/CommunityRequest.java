package fairy.spring.fairy.Community.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommunityRequest {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class TipRequestDTO{
        @NotBlank(message = "제목은 필수입니다.")
        private String title;
        @NotBlank(message = "내용은 필수입니다.")
        private String content;
        private String imageurl;
        private Long userid;
    }
}
