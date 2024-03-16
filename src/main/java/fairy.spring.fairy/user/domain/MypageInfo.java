package fairy.spring.fairy.user.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

@Data
@Getter
@Entity
public class MypageInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer point;
    @Column(nullable = false)
    private String grade;
    @Column(nullable = false)
    private String email;

    @Builder
    public MypageInfo(Long id,Integer point,String grade,String email) {
        this.id = id;
        this.email = email;
        this.point = point;
        this.grade = grade;
    }



}
