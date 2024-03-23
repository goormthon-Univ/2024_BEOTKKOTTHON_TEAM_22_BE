package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.user.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
public class BookmarkController {


    @Autowired
    public BookmarkController(BookmarkService bookmarkService) {
    }

    // 북마크 관련 API 엔드포인트 구현
}
