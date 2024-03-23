package fairy.spring.fairy.user.service;

import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.home.entity.Tip;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.domain.Checklist;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.BookmarkRepository;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final questionrepository questionrepository;



    // 북마크 생성
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
                .userid(user.getId())
                .build();

        Question question  = questionrepository.findById(bookmarkRequestDTO.getTipid()).orElseThrow(()-> new Exception400(null,"해당하는 글이없습니다."));
        int count = question.getBookmarkcount();
        question.setBookmarkcount(count+=1);
        return bookmarkRepository.save(bookmark);

    }



    // 북마크 해제 메서드
    @Transactional
    public void deleteBookmark(Long questionid){
        Bookmark bookmark = bookmarkRepository.findByQuestionid(questionid);
        bookmark.setBookmarkstatus(false);
    }

    @Transactional
    //북마크 목록 전체 조회
    public MypageResponse.BookmarkViewResponseDTO searchAll(Long userid){
        List<Bookmark> bookmarks = bookmarkRepository.findByUserid(userid);
        return new MypageResponse.BookmarkViewResponseDTO(bookmarks);
    }
}