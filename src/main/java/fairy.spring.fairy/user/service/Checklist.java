package fairy.spring.fairy.user.service;


import fairy.spring.fairy.user.repository.TodoRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class Checklist {

    /*
    TO DO: 체크 리스트 목록에 아이템 추가
         : 체크 리스트 목록에 아이템 삭제
         : 체크 리스트 목록에 아이템 수정
         : 체크 리스트 목록 전체 조회
         : 체크 리스트 목록 중 특정 아이템 조회
     */

    private final TodoRepository todoRepository;
//    @Transactional
    //체크 리스트 목록 전체 조회
    public MypageResponse.ChecklistViewResponseDTO searchAll(Long userid){
        List<fairy.spring.fairy.user.domain.Checklist> checklist = todoRepository.findByUserid(userid);
        return new MypageResponse.ChecklistViewResponseDTO(checklist);
    }
//    @Transactional
    //체크 리스트 목록 중 특정 아이템 조회
    public fairy.spring.fairy.user.domain.Checklist searchById(Long id){
        return new fairy.spring.fairy.user.domain.Checklist(id, "title", true, 1L);
//        return this.todoRepository.findById(id)
//                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
//    @Transactional
    //체크 리스트 목록에 아이템 추가
    public MypageResponse.TodolistResponseDTO add(MypageRequest.TodolistRequestDTO todolistRequestDTO,Long userid){
        fairy.spring.fairy.user.domain.Checklist checklist = fairy.spring.fairy.user.domain.Checklist.builder()
                .title(todolistRequestDTO.getTitle())
                .completed(todolistRequestDTO.getCompleted())
                .userid(userid)
                .build();
//        return new MypageResponse.TodolistResponseDTO(todoRepository.save(checklist));
        return new MypageResponse.TodolistResponseDTO(checklist);
    }
//    @Transactional
    // 체크 리스트 목록에 아이템 수정
    public MypageResponse.TodolistResponseDTO updateById(Long id, MypageRequest.TodolistRequestDTO todolistRequestDTO,Long userid){
        fairy.spring.fairy.user.domain.Checklist checklist = this.searchById(id);
        if(checklist.getTitle()!=null && checklist.getCompleted()!=null){
            checklist = new fairy.spring.fairy.user.domain.Checklist(id, todolistRequestDTO.getTitle(), todolistRequestDTO.getCompleted(),userid);
        }
        return new MypageResponse.TodolistResponseDTO(checklist);
//        return new MypageResponse.TodolistResponseDTO(todoRepository.save(checklist));
    }
//    @Transactional
    //체크 리스트 목록에 아이템 삭제
    public void deleteById(Long id){
//        this.todoRepository.deleteById(id);
    }

}
