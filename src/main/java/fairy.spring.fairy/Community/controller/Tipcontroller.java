package fairy.spring.fairy.Community.controller;

import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.Service.Tipservice;
import fairy.spring.fairy.config.utils.ApiResponseBuilder;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Tip", description = "팁 api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class Tipcontroller {

    private final Tipservice tipservice;

    @Operation(summary = "팁 등록", description = "팁을 등록합니다.")
    @ApiResponse(responseCode = "201", description = "팁 등록 성공")
    @PostMapping(value = "/community/tips")
    public ResponseEntity<?> createTip(@RequestBody @Valid CommunityRequest.TipRequestDTO tipRequestDTO) {
        CommunityResponse.TipResponseDTO tipResponseDTO = tipservice.createTip(tipRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.success(tipResponseDTO));
    }

}
