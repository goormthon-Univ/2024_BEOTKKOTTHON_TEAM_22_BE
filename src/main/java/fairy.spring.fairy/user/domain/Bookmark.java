package fairy.spring.fairy.user.domain;

import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.home.entity.Tip;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Setter
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean bookmarkstatus;

    @Column(nullable = false)
    private Long questionid;

    @Column(nullable = false)
    private Long tipid;



    @Builder
    public Bookmark(Boolean bookmarkstatus,Long questionid,Long tipid) {
        this.bookmarkstatus=bookmarkstatus;
        this.questionid=questionid;
        this.tipid=tipid;
    }


}
