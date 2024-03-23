package fairy.spring.fairy.Community.Request;



import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


import java.sql.Blob;
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
        @Getter
        private Blob imageurl;


        public QuestionRequestDTO(String email,String content,Blob imageurl) {
            this.email = email;
            this.content=content;
            this.imageurl=imageurl;
        }

        public QuestionRequestDTO(String email, String content, String title) {
            this.email = email;
            this.content = content;
            this.title = title;
        }
    }







    @Getter
    public static class QuestionimageRequestDTO {
        private List<MultipartFile> imageurl;
        private String content;
        private String title;
        private String email;

        public QuestionimageRequestDTO(List<MultipartFile> imageurl, String content, String title, String email) {
            this.imageurl = imageurl;
            this.content = content;
            this.email = email;
            this.title = title;
        }

        public QuestionRequestDTO getQuestionRequestDTO() {
            return new QuestionRequestDTO(
                    this.email,
                    this.content,
                    this.title
            );
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
