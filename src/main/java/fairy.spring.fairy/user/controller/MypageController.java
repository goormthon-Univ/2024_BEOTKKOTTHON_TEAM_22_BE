package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.config.auth.PrincipalUserDetails;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import fairy.spring.fairy.user.service.MypageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Tag(name="mypage", description = "마이페이지 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MypageController {

    private final MypageService mypageService;

    @Operation(summary = "프로필 업데이트", description = "프로필을 업데이트합니다.")
    @ApiResponse(responseCode = "201", description = "프로필 업데이트 성공")
    @GetMapping("/mypage/user")
    public ResponseEntity<?> updateProfile(@RequestBody @Valid MypageRequest.MypageinfoRequestDTO mypageinfoRequestDTO, @AuthenticationPrincipal PrincipalUserDetails userDetails) {
        MypageResponse.MypageinfoResponseDTO mypageinfoResponseDTO = mypageService.updateprofile(mypageinfoRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(mypageinfoResponseDTO));
    }
}
