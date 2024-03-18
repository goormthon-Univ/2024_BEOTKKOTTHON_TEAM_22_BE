package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class Questionservice {
    private final questionrepository questionrepository;
    private final UserRepository userRepository;




    @Transactional
    public CommunityResponse.questionResponseDTO createQuestion (CommunityRequest.questionRequestDTO questionRequestDTO){
        User user = userRepository.findByEmail(questionRequestDTO.getEmail())
                .orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        Question question = Question.builder()
               .title(questionRequestDTO.getTitle())
               .content(questionRequestDTO.getContent())
               .email(questionRequestDTO.getEmail())
               .build();
       return new CommunityResponse.questionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    // 질문 수정
    public CommunityResponse.questionResponseDTO updateById(Long question_id, CommunityRequest.questionRequestDTO questionRequestDTO){
        Question question = this.searchById(question_id);
        if(question.getTitle()!=null && question.getContent()!=null){
            question = new Question(question_id, questionRequestDTO.getTitle(), questionRequestDTO.getContent(),questionRequestDTO.getEmail());
        }
        return new CommunityResponse.questionResponseDTO(questionrepository.save(question));
    }

    @Transactional
    //질문 조회
    public Question searchById(Long question_id){
        return this.questionrepository.findById(question_id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
