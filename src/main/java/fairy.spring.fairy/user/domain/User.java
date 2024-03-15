package fairy.spring.fairy.user.domain;
import fairy.spring.fairy.config.utils.MetaData;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.springframework.stereotype.Component;

@Getter
@Component
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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


    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private RoleEnum role;

    @OneToOne(mappedBy = "user")
    private MypageInfo mypageInfo;



    @Builder
    public User(String email, String password, String nickname, RoleEnum role) {
        this.role = role;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
    }


}