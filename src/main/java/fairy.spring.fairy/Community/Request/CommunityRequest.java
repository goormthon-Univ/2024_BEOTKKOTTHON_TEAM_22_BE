package fairy.spring.fairy.Community.Request;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

public class CommunityRequest {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class questionRequestDTO{

        private String title;
        private String content;
        private String email;
        private List<String> imageurl;

        public questionRequestDTO(String email, String content,List<String> imageurl,String title) {
            this.email = email;
            this.content=content;
            this.imageurl=imageurl;
            this.title=title;
        }
    }




    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentRequestDTO{

        private Long itemid;
        private String type;
        private String content;
        private String email;
        public CommentRequestDTO(String email, String content, Long itemid, String type) {
            this.email = email;
            this.content=content;
            this.type=type;
            this.itemid=itemid;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CommentmodifyRequestDTO{

        private String content;

        public CommentmodifyRequestDTO(String content){
            this.content=content;
        }
    }




}
