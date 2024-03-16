package fairy.spring.fairy.user.request;

import fairy.spring.fairy.user.domain.Todolist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;



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

}
