package fairy.spring.fairy.Community.controller;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.Service.QuestionImageservice;
import fairy.spring.fairy.Community.Service.Questionservice;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name="Question", description = "질문 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Questioncontroller {

    private final Questionservice questionservice;
    private final QuestionImageservice questionImageservice;

    @Operation(summary = "질문 등록", description = "질문을 등록합니다.")
    @ApiResponse(responseCode = "200", description = "질문 등록 성공",
            content = @Content(mediaType = "application/json"))
    @PostMapping(value = "/community/question")
    public ResponseEntity<?> createQuestion(@RequestBody @Valid CommunityRequest.questionRequestDTO questionRequestDTO) {
        CommunityResponse.questionResponseDTO questionResponseDTO = questionservice.createQuestion(questionRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(questionResponseDTO));
    }

    @Operation(summary = "질문 이미지 등록", description = "질문 이미지를 등록합니다.")
    @ApiResponse(responseCode = "200", description = "질문 이미지 등록 성공")
    @PostMapping(value = "/community/question/post")
    public ResponseEntity<?> createQuestionImage(@ModelAttribute("imageurl") CommunityRequest.questionImageRequestDTO questionImageRequestDTO) {
        CommunityResponse.questionImageResponseDTO questionImageResponseDTO = questionImageservice.createQuestionImage(questionImageRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(questionImageResponseDTO));
    }

}
