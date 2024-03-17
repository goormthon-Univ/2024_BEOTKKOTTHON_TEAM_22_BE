package fairy.spring.fairy.Community.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class CommunityResponse {
    @Getter
    @Setter
    public static class questionResponseDTO{
        @Schema(description = "질문 고유 id", example = "1")
        private Long questionid;
        @Schema(description = "질문 작성 사용자 이메일", example = "1")
        private String email;
        public questionResponseDTO(Long questionid, String email){
            this.questionid= questionid;
            this.email=email;
        }
    }
}