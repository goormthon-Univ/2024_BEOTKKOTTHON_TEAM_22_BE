package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import fairy.spring.fairy.user.service.PointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Tag(name = "포인트 적립", description = "포인트 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PointController {
    private final PointService pointService;
    @Operation(summary = "포인트 적립", description = "포인트를 적립합니다.")
    @ApiResponse(responseCode = "200", description = "포인트 적립 성공")
    @PostMapping("/mypage/point/earn")
    public ResponseEntity<?> point(@RequestBody @Valid MypageRequest.PointRequestDTO pointRequestDTO, Errors errors) {
        MypageResponse.PointResponseDTO pointResponseDTO = pointService.getpoint(pointRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(pointResponseDTO));
    }

}
