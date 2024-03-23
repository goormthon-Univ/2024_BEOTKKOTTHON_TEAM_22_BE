package fairy.spring.fairy.Community.controller;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.Service.CommentService;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Tag(name="Comment", description = "댓글 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Commentcontroller {

    private final CommentService commentService;
    @Operation(summary = "댓글 등록", description = "댓글을 등록합니다.")
    @ApiResponse(responseCode = "201", description = "댓글 등록 성공")
    @PostMapping(value = "/community/comment")
    public ResponseEntity<?> createQuestion(@RequestBody @Valid CommunityRequest.CommentRequestDTO commentRequestDTO) {
        CommunityResponse.CommentResponseDTO commentResponseDTO = commentService.createComment(commentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(commentResponseDTO));
    }



    @Operation(summary = "댓글 수정", description = "댓글을 수정합니다.")
    @ApiResponse(responseCode = "200", description = "댓글 수정 성공")
    @PatchMapping("/community/comment/{comment_id}")
    public ResponseEntity<?> update(@PathVariable("comment_id") Long comment_id, CommunityRequest.CommentmodifyRequestDTO commentRequestDTO, Errors errors) {
        CommunityResponse.CommentResponseDTO commentResponseDTO =  commentService.updateByIdcomment(comment_id,commentRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }

    @Operation(summary = "댓글 삭제", description = "댓글을 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "댓글 삭제 성공")
    @DeleteMapping("/mypage/checklist/{userid}/{comment_id}")
    public ResponseEntity<?> delete (@PathVariable("userid") Long userid, @PathVariable("comment_id") Long comment_id, @org.springframework.web.bind.annotation.RequestBody @Valid CommunityRequest.CommentmodifyRequestDTO commentRequestDTO, Errors errors) {
        this.commentService.deleteById(comment_id);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }
}
