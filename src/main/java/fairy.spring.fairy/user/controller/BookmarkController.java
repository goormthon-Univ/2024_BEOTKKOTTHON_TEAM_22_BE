package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.domain.Bookmark;
import fairy.spring.fairy.user.repository.BookmarkRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import fairy.spring.fairy.user.service.BookmarkService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name="Bookmark", description = "북마크 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookmarkController {


    private final BookmarkService bookmarkService;
    private final BookmarkRepository bookmarkRepository;
    private final questionrepository questionrepository;

    @Operation(summary = "질문 북마크  생성", description = "북마크 목록을 생성합니다.")
    @ApiResponse(responseCode = "201", description = "북마크 목록 생성 성공")
    @PostMapping("/question/bookmark/{quesionid}")
    public ResponseEntity<?> create(@PathVariable("questionid") Long questionid,@RequestBody MypageRequest.BookmarkRequestDTO bookmarkRequestDTO) {
        bookmarkService.createBookmarkQuestion(bookmarkRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }


    @Operation(summary = "질문 북마크 해제", description = "북마크 목록을 해제합니다.")
    @ApiResponse(responseCode = "200", description = "북마크 목록 해제 성공")
    @DeleteMapping("/question/bookmark/{questionid}")
    public ResponseEntity<?> create(@PathVariable("questionid") Long questionid) {
        bookmarkService.deleteBookmark(questionid);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }

    @Operation(summary = "북마크 조회", description = "북마크를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "북마크 조회 성공")
    @GetMapping(value = "/mypage/bookmark/{userid}")
    public ResponseEntity<?> getProfile(@PathVariable("userid") Long userid) {
        MypageResponse.BookmarkViewResponseDTO BookmarkViewResponseDTO1 = bookmarkService.searchAll(userid);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(BookmarkViewResponseDTO1));
    }
}





