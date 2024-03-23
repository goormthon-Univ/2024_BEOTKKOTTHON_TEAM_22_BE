package fairy.spring.fairy.user.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;


public class MypageRequest {


    @Data
    @NoArgsConstructor
    public class MypageinfoRequestDTO{
//        @NotNull(message = "이메일은 필수 입력 값입니다.")
        private String email;
        private String a;


    }

    @Getter
    @NoArgsConstructor
    public static class TodolistRequestDTO{
        private String title;
        private Boolean completed;
        public TodolistRequestDTO(String title, Boolean completed) {
            this.title = title;
            this.completed = completed;
        }
    }

        @Getter
        @NoArgsConstructor
        public static class BookmarkRequestDTO {
            private Long questionid;
            private Long tipid;
            private String email;

            public BookmarkRequestDTO(Long tipid, Long questionid,String email) {
                this.questionid = questionid;
                this.tipid = tipid;
                this.email=email;
            }
        }





}




