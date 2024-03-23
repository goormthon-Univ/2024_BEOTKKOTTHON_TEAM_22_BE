package fairy.spring.fairy.home.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "category_id") // 카테고리와의 관계를 나타내는 외래 키
    private Category category;

    private String content;
    private boolean bookmarkStatus; // 북마크 상태를 나타내는 필드
    private int bookmarkCounts; // 북마크 수를 나타내는 필드

    @OneToMany(mappedBy = "tip")
    private List<Recommendation> recommendations;
    private String imageUrl;
    @Builder
    // 생성자를 통해 객체를 초기화할 수 있도록 생성자를 추가
    public Tip(String title, Category category, String content, long id, long categoryType, int bookmarkCounts, boolean bookmarkStatus, String imageUrl) {

        this.title = title;
        this.category = category;
        this.content = content;
        this.id = id;
        this.bookmarkCounts = bookmarkCounts;
        this.bookmarkStatus = bookmarkStatus;

    }

    // 필요한 setter 메서드들은 이미 Lombok을 통해 자동 생성됨

    // BookmarkStatus를 설정하는 setter 메서드 추가

}