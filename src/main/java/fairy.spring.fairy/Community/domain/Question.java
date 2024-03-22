package fairy.spring.fairy.Community.domain;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
//@Entity
@NoArgsConstructor
public class Question {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

//    @Column(nullable = false)
    private String title;

//    @Column(nullable = false)
    private String content;


//    @Column(nullable = false)
    private String email;

//    @Column(nullable = true)
    private List<String> imageurl;

//    @Column(nullable = false)
    private String nickname;

    @Builder
    public Question(Long id, String title, String content, String email,List<String> imageurl,String nickname) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email=email;
        this.imageurl=imageurl;
        this.nickname=nickname;

    }


}
