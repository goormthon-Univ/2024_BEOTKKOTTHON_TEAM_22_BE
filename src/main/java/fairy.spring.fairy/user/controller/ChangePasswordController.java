package fairy.spring.fairy.user.controller;

import fairy.spring.fairy.user.service.changepasswordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Tag(name = "User", description = "유저 API")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")

public class ChangePasswordController {
    @Autowired
    private final changepasswordService changepassword;
    @Operation(summary = "비밀번호 변경", description = "비밀번호를 변경합니다.")
    @ApiResponse(responseCode = "200", description = "변경 성공")
    @PatchMapping("/change-password")

    
    public ResponseEntity<?> updatePassword(@RequestBody @Valid UserRequest.PasswordDTO passwordDTO) {
        changepassword.changePassword(passwordDTO);
        return ResponseEntity.status(HttpStatus.OK).body(ApiResponseBuilder.successWithNoContent());
    }
}
