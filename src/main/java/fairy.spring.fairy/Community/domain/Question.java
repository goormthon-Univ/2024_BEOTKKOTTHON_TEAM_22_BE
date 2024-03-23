package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.websocket.Encoder;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;


    @Column(nullable = false)
    private String email;



    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer bookmarkcount;

    @Column(nullable = false)
    private Integer commentcount;

    @Column(nullable = false)
    private LocalDateTime timestamp;


    private boolean bookmarkstatus;

    private String profileurl;

    private List<String> url;


    @Builder
    public Question(Long id, String title, String content, String email,String nickname,String category,Integer bookmarkcount,Integer commentcount,LocalDateTime timestamp,boolean bookmarkstatus,String profileurl,List<String> url) {
        this.id = id;
        this.title = title;
        this.content= content;
        this.email=email;
        this.nickname=nickname;
        this.category=category;
        this.bookmarkcount=bookmarkcount;
        this.commentcount=commentcount;
        this.timestamp=timestamp;
        this.bookmarkstatus=bookmarkstatus;
        this.profileurl=profileurl;
        this.url=url;

    }


}
