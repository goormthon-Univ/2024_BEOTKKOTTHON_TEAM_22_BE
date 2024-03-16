package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postContent;

    @Column(nullable = false)
    private Integer postId;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String category;
    @Column(nullable = false)
    private Integer countcomment;
    @Column(nullable = false)
    private Integer scrap;
    @Builder
    public Post(Long id, Integer postId, String postTitle, String postContent, String createdAt, String category,Integer countcomment,Integer scrap) {
        this.id = id;
        this.postId=postId;
        this.postTitle=postTitle;
        this.postContent=postContent;
        this.createdAt=createdAt;
        this.category=category;
        this.countcomment=countcomment;
        this.scrap=scrap;
    }



}
