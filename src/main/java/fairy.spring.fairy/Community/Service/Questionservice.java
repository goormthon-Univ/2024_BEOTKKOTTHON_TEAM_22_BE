package fairy.spring.fairy.Community.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.S3.S3UploadService;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

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
       question = questionrepository.save(question);
       return new CommunityResponse.questionResponseDTO(question.getId(),questionRequestDTO.getEmail());
    }
}
