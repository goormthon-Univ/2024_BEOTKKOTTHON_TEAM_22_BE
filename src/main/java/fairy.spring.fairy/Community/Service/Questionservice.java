package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Questionservice {
    private final questionrepository questionrepository;

    @Transactional
    public CommunityResponse.questionResponseDTO createQuestion (CommunityRequest.questionRequestDTO questionRequestDTO){
       Question question = Question.builder()
               .title(questionRequestDTO.getTitle())
               .content(questionRequestDTO.getContent())
               .imageUrl(questionRequestDTO.getImageurl())
               .id(questionRequestDTO.getUserid())
               .build();
       question = questionrepository.save(question);
       return new CommunityResponse.questionResponseDTO(question.getId(),questionRequestDTO.getUserid());
    }
}
