package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
public class MypageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer point;
    @Column(nullable = false)
    private String grade;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
