package fairy.spring.fairy.user.service;


import fairy.spring.fairy.user.repository.TodoRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;


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
    @Transactional
    //체크 리스트 목록 전체 조회
    public MypageResponse.ChecklistViewResponseDTO searchAll(Long userid){
        List<fairy.spring.fairy.user.domain.Checklist> checklist = Arrays.asList(
                fairy.spring.fairy.user.domain.Checklist.builder()
                        .title("자취 필수템 확인하셨나요?")
                        .id(1L)
                        .completed(false)
                        .build(),
                fairy.spring.fairy.user.domain.Checklist.builder()
                        .title("효율적인 설거지를 하고 있나요?")
                        .id(2L)
                        .completed(false)
                        .build(),
                fairy.spring.fairy.user.domain.Checklist.builder()
                        .title("화장실 청소 하셨나요?")
                        .id(3L)
                        .completed(false)
                        .build()
        );
        return new MypageResponse.ChecklistViewResponseDTO(checklist);
    }
    @Transactional
    //체크 리스트 목록 중 특정 아이템 조회
    public fairy.spring.fairy.user.domain.Checklist searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @Transactional
    //체크 리스트 목록에 아이템 추가
    public MypageResponse.TodolistResponseDTO add(MypageRequest.TodolistRequestDTO todolistRequestDTO,Long userid){
        fairy.spring.fairy.user.domain.Checklist checklist = fairy.spring.fairy.user.domain.Checklist.builder()
                .title(todolistRequestDTO.getTitle())
                .completed(todolistRequestDTO.getCompleted())
                .userid(userid)
                .build();
        return new MypageResponse.TodolistResponseDTO(todoRepository.save(checklist));
    }
    @Transactional
    // 체크 리스트 목록에 아이템 수정
    public MypageResponse.TodolistResponseDTO updateById(Long id, MypageRequest.TodolistRequestDTO todolistRequestDTO,Long userid){
        fairy.spring.fairy.user.domain.Checklist checklist = this.searchById(id);
        if(checklist.getTitle()!=null && checklist.getCompleted()!=null){
            checklist = new fairy.spring.fairy.user.domain.Checklist(id, todolistRequestDTO.getTitle(), todolistRequestDTO.getCompleted(),userid);
        }
        return new MypageResponse.TodolistResponseDTO(todoRepository.save(checklist));
    }
    @Transactional
    //체크 리스트 목록에 아이템 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

}
