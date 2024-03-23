package fairy.spring.fairy.user.service;

import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.BookmarkRepository;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;



    // 북마크 생성,
    public Bookmark createBookmarkTip(Long tipid) {
        Bookmark bookmark = Bookmark.builder()
                .bookmarkstatus(true)
                .tipid(tipid)
                .build();
        return bookmarkRepository.save(bookmark);
    }

    public Bookmark createBookmarkQuestion(MypageRequest.BookmarkRequestDTO bookmarkRequestDTO) {
        User user = userRepository.findByEmail(bookmarkRequestDTO.getEmail()).orElseThrow(()-> new Exception400(null, "로그인을 해주세요."));
        Bookmark bookmark = Bookmark.builder()
                .bookmarkstatus(true)
                .questionid(bookmarkRequestDTO.getQuestionid())
                .build();
        return bookmarkRepository.save(bookmark);

    }



    // 북마크 해제 메서드
    @Transactional
    public void deleteBookmark(Long questionid){
        Bookmark bookmark = bookmarkRepository.findByQuestionid(questionid);
        bookmark.setBookmarkstatus(false);
    }
}