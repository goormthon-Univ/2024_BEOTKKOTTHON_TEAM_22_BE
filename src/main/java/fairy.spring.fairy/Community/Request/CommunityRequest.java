package fairy.spring.fairy.Community.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommunityRequest {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class TipRequestDTO{
        private String title;
        private String content;
        private String imageurl;
        private Long userid;
    }
}
