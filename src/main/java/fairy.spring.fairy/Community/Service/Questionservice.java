package fairy.spring.fairy.Community.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.BookmarkRepository;
import fairy.spring.fairy.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class Questionservice {
    private final questionrepository questionrepository;
    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;
    private final S3UploadService s3UploadService;


   //질문 등록
    @Transactional
    @JsonProperty
    public CommunityResponse.QuestionResponseDTO createQuestion(CommunityRequest.QuestionRequestDTO questionimageRequestDTO) throws IOException {
        User user = userRepository.findByEmail(questionimageRequestDTO.getEmail())
                .orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        LocalDateTime currentTime = LocalDateTime.now();
        Question question = Question.builder()
                .title(questionimageRequestDTO.getTitle())
                .content(questionimageRequestDTO.getContent())
                .email(questionimageRequestDTO.getEmail())
                .nickname(user.getNickname())
                .category("질문")
                .timestamp(currentTime)
                .bookmarkcount(0)
                .commentcount(0)
                .bookmarkstatus(false)
                .build();
        //포인트 적립
        int currentpoint=user.getTotalpoint();
        user.setTotalpoint(currentpoint+10);
        userRepository.save(user);
        questionrepository.save(question);
       s3UploadService.uploadMultipleFiles(questionimageRequestDTO.getImageurl());
        return new CommunityResponse.QuestionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    // 질문 수정
    public CommunityResponse.QuestionResponseDTO updateById(Long question_id, CommunityRequest.QuestionRequestDTO questionimageRequestDTO) throws IOException {
        Question question = this.searchById(question_id);
        if (question.getTitle() != null && question.getContent() != null) {
            question.setTitle(questionimageRequestDTO.getTitle());
            question.setContent(questionimageRequestDTO.getContent());
        }
        s3UploadService.uploadMultipleFiles(questionimageRequestDTO.getImageurl());
        return new CommunityResponse.QuestionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    //질문 조회
    public Question searchById(Long question_id) {
        return this.questionrepository.findById(question_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    //질문 목록 전체 조회
    public CommunityResponse.viewquestionResponseDTO searchAll(){
        List<Question> questions = questionrepository.findAll();
        return new CommunityResponse.viewquestionResponseDTO(questions);
    }
}


