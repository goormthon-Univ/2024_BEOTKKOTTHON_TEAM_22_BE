package fairy.spring.fairy.Community.Response;

import fairy.spring.fairy.Community.domain.Comment;
import fairy.spring.fairy.Community.domain.Question;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class CommunityResponse {
    @Getter
    @NoArgsConstructor
    public static class QuestionResponseDTO{
        @Schema(description = "질문 고유 id", example = "1")
        private Long id;
        @Schema(description = "질문 작성 사용자 이메일", example = "1")
        private String email;
        @Schema(description = "질문자 닉네임")
        private String nickname;

        public QuestionResponseDTO(Question question){
            this.id= question.getId();
            this.email=question.getEmail();
            this.nickname=question.getNickname();

        }
    }



    @Getter
    @NoArgsConstructor
    public static class viewquestionResponseDTO{
        private List<Question> questions;

        public viewquestionResponseDTO(List<Question> questions){
            this.questions=questions;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class viewqdetailquestionResponseDTO{
        private List<Question> questions;
        private List<Comment> comments;

        public viewqdetailquestionResponseDTO(List<Question> questions, List<Comment> comments){

            this.questions=questions;
            this.comments=comments;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class CommentResponseDTO{
        @Schema(description = "댓글 작성자 고유 id")
        private Long userid;
        @Schema(description = "댓글 고유 id")
        private Long commentid;

        public CommentResponseDTO(Comment comment){
            this.userid= userid;
            this.commentid=commentid;
        }
    }
}
