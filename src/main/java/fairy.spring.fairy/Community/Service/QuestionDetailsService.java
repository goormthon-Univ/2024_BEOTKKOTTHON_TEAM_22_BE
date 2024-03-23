package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Repository.Commentrepository;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Comment;
import fairy.spring.fairy.Community.domain.Question;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionDetailsService {

    private final fairy.spring.fairy.Community.Repository.questionrepository questionrepository;
    private final Commentrepository commentrepository;
    @Transactional
    //자세한 질문 목록 전체 조회
    public CommunityResponse.viewqdetailquestionResponseDTO searchdetailsAll(Long questionid){
        Optional<Question> question = questionrepository.findById(questionid);
        Optional<Comment> comment = commentrepository.findById(questionid);
        return new CommunityResponse.viewqdetailquestionResponseDTO(question,comment);
    }





}
