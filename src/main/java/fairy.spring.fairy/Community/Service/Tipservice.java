package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Repository.Tiprepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Tip;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Tipservice {
    private final Tiprepository tiprepository;

    @Transactional
    public CommunityResponse.TipResponseDTO createTip (CommunityRequest.TipRequestDTO tipRequestDTO){
       Tip tip = Tip.builder()
               .title(tipRequestDTO.getTitle())
               .content(tipRequestDTO.getContent())
               .imageUrl(tipRequestDTO.getImageurl())
               .build();
       tip=tiprepository.save(tip);
       return new CommunityResponse.TipResponseDTO(tipRequestDTO.getUserid(),tip.getId());
    }
}
