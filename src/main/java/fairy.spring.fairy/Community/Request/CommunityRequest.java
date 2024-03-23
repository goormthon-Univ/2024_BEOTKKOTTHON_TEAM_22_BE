package fairy.spring.fairy.Community.Request;



import lombok.Getter;
import lombok.NoArgsConstructor;



import java.util.List;
@NoArgsConstructor
public class CommunityRequest {

    @Getter
    public static class QuestionRequestDTO {
        @Getter
        private String title;
        @Getter
        private String content;
        @Getter
        private String email;
        private List<String> imageurl;



        public QuestionRequestDTO(String email, String content, List<String> imageurl, String title) {
            this.email = email;
            this.content=content;
            this.imageurl=imageurl;
            this.title=title;
        }



    }







    @Getter
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
    public static class CommentmodifyRequestDTO{

        private String content;

        public CommentmodifyRequestDTO(String content){
            this.content=content;
        }
    }




}
