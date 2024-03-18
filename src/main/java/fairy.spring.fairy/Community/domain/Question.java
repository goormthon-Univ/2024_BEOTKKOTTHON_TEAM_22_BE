package fairy.spring.fairy.Community.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

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


    @Column(nullable = true)
    private String email;

    @Builder
    public Question(Long id, String title, String content, String email) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.email=email;

    }


}
