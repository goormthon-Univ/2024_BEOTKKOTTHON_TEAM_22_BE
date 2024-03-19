package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionImageservice {
    private final S3UploadService s3UploadService;

    @SneakyThrows
    @Transactional
    public CommunityResponse.questionImageResponseDTO createQuestionImage(CommunityRequest.questionImageRequestDTO questionImageRequestDTO) {
        List<String> questionImage = s3UploadService.uploadMultipleFiles(questionImageRequestDTO.getImageurl());
        return new CommunityResponse.questionImageResponseDTO(questionImage);
    }
}
