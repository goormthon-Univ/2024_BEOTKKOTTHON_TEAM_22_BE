package fairy.spring.fairy.home.entity;
import jakarta.persistence.*;
//import fairy.spring.fairy.home.entity.Recommendation;

//import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

import java.util.List;

@Entity
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


    @OneToMany(mappedBy = "tip")
    private List<Recommendation> recommendations;

    public int getBookmarkCounts(){
        return recommendations.size();
    }

    public boolean getBookmarkStatus(){
        return recommendations.size() > 0;
    }
}