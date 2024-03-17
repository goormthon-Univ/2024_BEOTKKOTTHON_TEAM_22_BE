package fairy.spring.fairy.user.service;

import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.repository.MypageRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointService {

    private final MypageRepository mypageRepository;

    //포인트 적립
    @Transactional
    public MypageResponse.PointResponseDTO getpoint(MypageRequest.PointRequestDTO pointRequestDTO){
        MypageInfo mypageInfo = mypageRepository.findByEmail(pointRequestDTO.getEmail()).orElseThrow(() -> new Exception400(null, "유저가 존재하지 않습니다."));
        int currentpoint=mypageInfo.getPoint();
        if(pointRequestDTO.getAction().equals("댓글 달기") || pointRequestDTO.getAction().equals("질문 달기")){
            mypageInfo.setPoint(currentpoint+10);
        }
        if(pointRequestDTO.getAction().equals("팁 등록")){
            mypageInfo.setPoint(currentpoint+100);
        }
        mypageInfo = mypageRepository.save(mypageInfo);
        return new MypageResponse.PointResponseDTO(mypageInfo.getPoint());

    }

}
