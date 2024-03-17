package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import lombok.*;



@Setter
@Getter
@Entity
@NoArgsConstructor
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    private String imageUrl;

    @Builder
    public Tip(Long id, String title, String content, String imageUrl) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;

    }


}
