package fairy.spring.fairy.user.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class MypageRequest {

    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public class MypageinfoRequestDTO {
        private String email;

        public MypageinfoRequestDTO(String email) {
            this.email = email;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TodolistRequestDTO {
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

        public BookmarkRequestDTO(Long tipid, Long questionid, String email) {
            this.questionid = questionid;
            this.tipid = tipid;
            this.email = email;
        }
    }
}




