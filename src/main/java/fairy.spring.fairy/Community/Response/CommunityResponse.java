package fairy.spring.fairy.Community.Response;

import fairy.spring.fairy.Community.domain.Comment;
import fairy.spring.fairy.Community.domain.Question;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

public class CommunityResponse {
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class questionResponseDTO{
        @Schema(description = "질문 고유 id", example = "1")
        private Long id;
        @Schema(description = "질문 작성 사용자 이메일", example = "1")
        private String email;
        @Schema(description = "질문 작성 이미지 url")
        private List<String> imageurl;
        @Schema(description = "질문자 닉네임")
        private String nickname;

        public questionResponseDTO(Question question){
            this.id= question.getId();
            this.email=question.getEmail();
            this.imageurl=question.getImageurl();
            this.nickname=getNickname();

        }
    }



    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class viewquestionResponseDTO{
        @Schema(description = "질문 제목")
        private List<Question> title;
        @Schema(description = "질문 내용")
        private List<Question> content;
        @Schema(description = "질문 고유 아이디")
        private List<Question> id ;

        public viewquestionResponseDTO(List<Question> questions){
            this.id=id;
            this.title=title;
            this.content=content;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
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
