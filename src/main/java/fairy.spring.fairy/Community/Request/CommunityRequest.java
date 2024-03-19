package fairy.spring.fairy.Community.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
@NoArgsConstructor
public class CommunityRequest {

    @Getter
    @Setter
    public class questionRequestDTO{

        private String title;
        private String content;
        private String email;
    }


    @Getter
    @Setter
    public class questionImageRequestDTO{

        private List<MultipartFile> imageurl;
    }






}
