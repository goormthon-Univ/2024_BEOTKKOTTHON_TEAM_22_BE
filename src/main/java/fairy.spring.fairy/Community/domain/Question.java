package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import lombok.*;



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
    
    @Column(nullable = true)
    private String imageUrl;

    @Column(nullable = true)
    private String email;

    @Builder
    public Question(Long id, String title, String content, String imageUrl, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.email=email;

    }


}
