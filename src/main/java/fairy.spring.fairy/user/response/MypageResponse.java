package fairy.spring.fairy.user.response;

import fairy.spring.fairy.user.domain.Todolist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

public class MypageResponse {
    @Getter
    @Setter
    public static class MypageinfoResponseDTO{
        @Schema(description = "닉네임", example = "chee0630")
        private String nickname;
        @Schema(description = "사용자 누적 포인트", example = "250")
        private Integer totalpoint;
        @Schema(description = "사용자 등급", example = "요정")
        private String grade;

        public MypageinfoResponseDTO(String nickname, Integer totalpoint, String grade){
            this.nickname=nickname;
            this.totalpoint=totalpoint;
            this.grade=grade;
        }
    }

    @Getter
    @Setter
    public static class TodolistResponseDTO{
        @Schema(description = "to do 리스트 제목 ", example = "설거지 하기 ")
        private String Title;
        @Schema(description = "to do 리스트 고유 id", example = "1")
        private Long Todoid;
        public TodolistResponseDTO(Todolist todolist){
            this.Title= todolist.getTitle();
            this.Todoid=todolist.getId();
        }
    }

    @Getter
    @Setter
    public static class PointResponseDTO{
        @Schema(description = "획득한 총 포인트 ", example = "10")
        private Integer totalpoint;
        public PointResponseDTO(Integer point){
            this.totalpoint= point;
        }
    }

    @Getter
    @Setter
    public static class PostResponseDTO{
        @Schema(description = "작성 글 고유 id", example = "1")
        private Integer postId;
        @Schema(description = "작성 글 제목", example = "설거지 하는 법" )
        private String postTitle;
        @Schema(description = "작성 글 내용", example = "설거지는 바로 바로 해야 합니다." )
        private String postContent;
        @Schema(description = "글 작성 시간", example = "2024-03-15 T15:00:00Z" )
        private String createdAt;
        @Schema(description = "작성 글 카테고리", example = "tip" )
        private String category;
        @Schema(description = "댓글 수", example = "10" )
        private Integer countcomment;
        @Schema(description = "스크랩 수", example = "10" )
        private Integer scrap;

        public PostResponseDTO(Integer postId, String postTitle, String postContent, String createdAt, String category, Integer countcomment, Integer scrap){
            this.postId=postId;
            this.postTitle=postTitle;
            this.postContent=postContent;
            this.createdAt=createdAt;
            this.category=category;
            this.countcomment=countcomment;
            this.scrap=scrap;
        }
    }


}
