package fairy.spring.fairy.user.response;

import fairy.spring.fairy.user.domain.Checklist;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class MypageResponse {
    @Getter
    @NoArgsConstructor
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
    @NoArgsConstructor
    public static class TodolistResponseDTO{
        @Schema(description = "체크 리스트 제목 ", example = "설거지 하기 ")
        private String Title;
        @Schema(description = "체크 리스트 고유 id", example = "1")
        private Long Checklistid;
        public TodolistResponseDTO(Checklist checklist){
            this.Title= checklist.getTitle();
            this.Checklistid= checklist.getId();
        }
    }

    @Getter
    @NoArgsConstructor
    public static class ChecklistViewResponseDTO{
        private List<Checklist> checklists;

        public ChecklistViewResponseDTO(List<Checklist> checklists){
           this.checklists=checklists;
        }
    }


    }







