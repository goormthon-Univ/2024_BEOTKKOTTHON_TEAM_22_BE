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
        @Schema(description = "질문 작성 사용자 고유 id", example = "1")
        private Long userid;
        public questionResponseDTO(Long questionid, Long userid){
            this.questionid= questionid;
            this.userid=userid;
        }
    }
}
