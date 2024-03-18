package fairy.spring.fairy.Community.Request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

public class CommunityRequest {

    @NoArgsConstructor
    @Getter
    @Setter
    public class questionRequestDTO{

        private String title;
        private String content;
        private String email;
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public class questionImageRequestDTO{

        private List<MultipartFile> imageurl;
    }




}
