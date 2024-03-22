package fairy.spring.fairy.Community.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
//@Entity
@NoArgsConstructor
public class Comment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long commentid;

//    @Column(nullable = false)
    private String type;

//    @Column(nullable = false)
    private String content;


//    @Column(nullable = false)
    private String email;

//    @Column(nullable = false)
    private Long itemid;



    @Builder
    public Comment(Long commentid, String type, String content, Long itemid,String email) {
        this.commentid = commentid;
        this.type = type;
        this.content = content;
        this.email=email;
        this.itemid=itemid;

    }

}
