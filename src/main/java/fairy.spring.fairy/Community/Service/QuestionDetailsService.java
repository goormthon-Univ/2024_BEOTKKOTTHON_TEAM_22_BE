package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionDetailsService {

    private final fairy.spring.fairy.Community.Repository.questionrepository questionrepository;

    @Transactional
    //질문 목록 전체 조회
    public CommunityResponse.viewquestionResponseDTO searchAll(){
        List<Question> questiondetails = questionrepository.findAll();
        return new CommunityResponse.viewquestionResponseDTO(questiondetails);
    }





}
