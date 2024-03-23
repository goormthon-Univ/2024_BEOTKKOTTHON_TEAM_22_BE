package fairy.spring.fairy.home.entity;

import jakarta.persistence.*;
//import lombok.AccessLevel;
import lombok.Getter;
//import lombok.NoArgsConstructor;
import lombok.Setter;

//import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @Enumerated(EnumType.STRING)
    private CategoryType type;

}