package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import fairy.spring.fairy.user.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


@Tag(name = "to do 리스트", description = "to do 리스트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TodoController {
    private TodoService todoService;

    @Operation(summary = "to do 리스트 목록 생성", description = "to do 리스트 목록을 생성합니다.")
    @ApiResponse(responseCode = "201", description = "to do 리스트 목록 생성 성공")
    @PostMapping("/mypage/todo/{userid}")
    public ResponseEntity<?> create(@PathVariable("userid") Long userid, @RequestBody @Valid MypageRequest.TodolistRequestDTO todolistRequestDTO, Errors errors) {
        MypageResponse.TodolistResponseDTO todolistResponseDTO =todoService.add(todolistRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(todolistResponseDTO));
    }

    @Operation(summary = "to do 리스트 목록 삭제", description = "to do 리스트 목록을 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "to do 리스트 목록 삭제 성공")
    @DeleteMapping("/mypage/todo/{userid}/{todoid}")
    public ResponseEntity<?> delete (@PathVariable("userid") Long userid, @PathVariable("todoid") Long todoid, @RequestBody @Valid MypageRequest.TodolistRequestDTO todolistRequestDTO, Errors errors) {
        this.todoService.deleteById(userid);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }

    @Operation(summary = "to do 리스트 목록 수정", description = "to do 리스트 목록을 수정합니다.")
    @ApiResponse(responseCode = "200", description = "to do 리스트 목록 수정 성공")
    @PostMapping("/mypage/todo/{userid}/{todoid}")
    public ResponseEntity<?> update(@PathVariable("userid") Long userid, @RequestBody @Valid MypageRequest.TodolistRequestDTO todolistRequestDTO, Errors errors) {
        MypageResponse.TodolistResponseDTO todolistResponseDTO =todoService.updateById(userid,todolistRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(todolistResponseDTO));
    }
}
