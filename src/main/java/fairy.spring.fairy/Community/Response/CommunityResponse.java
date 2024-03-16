package fairy.spring.fairy.Community.Response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class CommunityResponse {
    @Getter
    @Setter
    public static class TipResponseDTO{
        @Schema(description = "팁 고유 id", example = "1")
        private Long tipid;
        @Schema(description = "팁 작성 사용자 고유 id", example = "1")
        private Long userid;
        public TipResponseDTO(Long tipid, Long userid){
            this.tipid= tipid;
            this.userid=userid;
        }
    }
}
