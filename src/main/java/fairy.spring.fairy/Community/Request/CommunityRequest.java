package fairy.spring.fairy.Community.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommunityRequest {

    @NoArgsConstructor
    @Getter
    @Setter
    public class questionRequestDTO{

        private String title;
        private String content;
        private String imageurl;
        private Long userid;
    }


}
