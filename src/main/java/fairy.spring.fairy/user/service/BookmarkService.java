package fairy.spring.fairy.user.service;

import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.BookmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkService(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    // 북마크 생성,
    public Bookmark createBookmark(User user, Tip tip) {
        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);
        bookmark.setTip(tip);
        return bookmarkRepository.save(bookmark);
    }

    // 삭제
    // 북마크 삭제 메서드
    public void deleteBookmark(User user, Tip tip) {
        Bookmark bookmark = bookmarkRepository.findByUserAndTip(user, tip);
        if (bookmark != null) {
            bookmarkRepository.delete(bookmark);
        }
    }
}