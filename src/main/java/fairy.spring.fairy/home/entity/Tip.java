package fairy.spring.fairy.home.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tip {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

//    @ManyToOne
//    @JoinColumn(name = "category_id") // 카테고리와의 관계를 나타내는 외래 키
    private Category category;

    private String content;

    // 다른 필드와 관련된 코드들...

    //@OneToMany(mappedBy = "tip")
    //private List<Recommendation> recommendations;
}
