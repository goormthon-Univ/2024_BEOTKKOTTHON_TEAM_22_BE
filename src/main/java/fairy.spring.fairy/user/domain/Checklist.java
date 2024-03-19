package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor
@Setter
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private Boolean completed;
    @Builder
    public Checklist(Long id, String Title, Boolean completed) {
        this.id = id;
        this.Title=Title;
        this.completed=completed;
    }
}
