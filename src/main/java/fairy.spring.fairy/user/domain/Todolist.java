package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;
@Getter
@Entity
@NoArgsConstructor
@Setter
public class Todolist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String Title;

    @Column(nullable = false)
    private Boolean completed;
    @Builder
    public Todolist(Long id, String Title, Boolean completed) {
        this.id = id;
        this.Title=Title;
        this.completed=completed;
    }
}
