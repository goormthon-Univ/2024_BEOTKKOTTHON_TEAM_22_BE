package fairy.spring.fairy.user.domain;

import lombok.Data;

@Data
public class Bookmark {
    private Long id;
    private String userId;
    private Long tipId;
    private boolean bookmarked; // 북마크 여부


}