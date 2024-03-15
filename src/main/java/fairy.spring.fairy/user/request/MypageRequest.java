package fairy.spring.fairy.user.request;

import lombok.Getter;
import lombok.Setter;

public class MypageRequest {

    @Getter
    @Setter
    public static class MypageinfoRequestDTO{
        private String nickname;
        private Integer totalpoint;
        private String grade;
    }

    @Getter
    @Setter
    public static class TodolistRequestDTO{
        private String Title;
        private Boolean completed;
    }
}
