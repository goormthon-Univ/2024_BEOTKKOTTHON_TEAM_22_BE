package fairy.spring.fairy.user.controller;


import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import fairy.spring.fairy.user.service.MypageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "mypage", description = "마이페이지 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MypageController {

    private final MypageService mypageService;

    @Operation(summary = "프로필 조회", description = "프로필을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "프로필 조회 성공")
    @GetMapping(value = "/mypage")
    public ResponseEntity<?> getProfile(@RequestBody MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO) {
        // jwt 헤더에 담기
        MypageResponse.MypageinfoResponseDTO mypageinfoResponseDTO = mypageService.updateprofile(mypageinfoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(mypageinfoResponseDTO));
    }
}