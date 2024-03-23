package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentid;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String content;


    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private Long itemid;

    @Column(nullable = false)
    private LocalDateTime timestamp;



    @Builder
    public Comment(Long commentid, String type, String content, Long itemid,String email,String nickname,LocalDateTime timestamp) {
        this.commentid = commentid;
        this.type = type;
        this.content = content;
        this.email=email;
        this.itemid=itemid;
        this.nickname=nickname;
        this.timestamp=timestamp;

    }

}
