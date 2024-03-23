package fairy.spring.fairy.user.domain;
import fairy.spring.fairy.config.utils.MetaData;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "UPDATE users SET deleted_at = CURRENT_TIMESTAMP, is_deleted = TRUE where id = ?")
@Entity
@Table(name = "users")
public class User extends MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;



    @Column(name = "totalpoint")
    private int totalpoint;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private RoleEnum role;

    @Column(name = "grade", nullable = false)
    private String grade;

    @Column(name = "profile image", nullable = false)
    private String profileimage;






    @Builder
    public User(String email, String password, String nickname, RoleEnum role, int totalpoint,Long id,String grade,String profileimage) {
        this.role = role;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.totalpoint=totalpoint;
        this.id=id;
        this.grade=grade;
        this.profileimage=profileimage;
    }
}