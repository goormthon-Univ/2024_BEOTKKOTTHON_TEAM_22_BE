package fairy.spring.fairy.user.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class MypageRequest {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class MypageinfoRequestDTO{
        private String email;

        public MypageinfoRequestDTO(String email) {
            this.email = email;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class TodolistRequestDTO{
        private String title;
        private Boolean completed;
        public TodolistRequestDTO(String title, Boolean completed) {
            this.title = title;
            this.completed = completed;
        }

    }



    }




