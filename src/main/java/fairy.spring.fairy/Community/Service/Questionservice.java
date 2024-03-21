package fairy.spring.fairy.Community.Service;

import com.fasterxml.jackson.annotation.JsonProperty;
import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.Checklist;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Questionservice {
    private final questionrepository questionrepository;
    private final UserRepository userRepository;

   //질문 등록
    @Transactional
    @JsonProperty
    public CommunityResponse.questionResponseDTO createQuestion(CommunityRequest.questionRequestDTO questionRequestDTO) {
        User user = userRepository.findByEmail(questionRequestDTO.getEmail())
                .orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .email(questionRequestDTO.getEmail())
                .imageurl(questionRequestDTO.getImageurl())
                .nickname(user.getNickname())
                .build();
        //포인트 적립
        int currentpoint=user.getTotalpoint();
        user.setTotalpoint(currentpoint+10);
        userRepository.save(user);
        return new CommunityResponse.questionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    // 질문 수정
    public CommunityResponse.questionResponseDTO updateById(Long question_id, CommunityRequest.questionRequestDTO questionRequestDTO) {
        Question question = this.searchById(question_id);
        if (question.getTitle() != null && question.getContent() != null) {
            question.setTitle(questionRequestDTO.getTitle());
            question.setContent(questionRequestDTO.getContent());
            question.setImageurl(questionRequestDTO.getImageurl());
        }
        return new CommunityResponse.questionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    //질문 조회
    public Question searchById(Long question_id) {
        return this.questionrepository.findById(question_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    //질문 목록 전체 조회
    public List<Question> searchAll(){

        return (List<Question>) new CommunityResponse.viewquestionResponseDTO(questionrepository.findAll());
    }
}


