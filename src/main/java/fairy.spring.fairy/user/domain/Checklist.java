package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter
public class Checklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Boolean completed;

    @Column(nullable = false)
    private Long userid;

    @Builder
    public Checklist(Long id, String title, Boolean completed,Long userid) {
        this.id = id;
        this.title=title;
        this.completed=completed;
        this.userid=userid;
    }
}
