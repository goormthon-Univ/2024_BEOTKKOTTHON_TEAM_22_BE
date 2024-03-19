package fairy.spring.fairy.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class MypageRequest {
    @NoArgsConstructor
    @Getter
    @Setter
    public static class MypageinfoRequestDTO{
        private String email;
        private Integer totalpoint;
        private String grade;
    }
    @NoArgsConstructor
    @Getter
    @Setter
    public static class TodolistRequestDTO{
        private String Title;
        private Boolean completed;

    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class PointRequestDTO{
        private String action;
        private String email;

    }



}
