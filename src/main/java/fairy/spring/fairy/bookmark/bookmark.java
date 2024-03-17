package fairy.spring.fairy.bookmark;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.lang.reflect.Member;

@Getter
@Entity
public class bookmark {
    @Id
    private Long id;

    private Member member;

    private Tip home;
}
