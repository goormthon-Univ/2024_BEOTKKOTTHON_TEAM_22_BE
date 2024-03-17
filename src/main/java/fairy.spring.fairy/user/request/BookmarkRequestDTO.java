package fairy.spring.fairy.user.request;

import lombok.Data;

@Data
public class BookmarkRequestDTO {
    private String userId;
    private String bookmarkUrl;
}