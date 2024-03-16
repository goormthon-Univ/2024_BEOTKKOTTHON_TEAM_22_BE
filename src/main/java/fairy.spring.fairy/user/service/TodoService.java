package fairy.spring.fairy.user.service;

import fairy.spring.fairy.user.domain.MypageInfo;
import fairy.spring.fairy.user.domain.Todolist;
import fairy.spring.fairy.user.repository.TodoRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TodoService {

    /*
    TO DO: To - do 리스트 목록에 아이템 추가
         : To - do 리스트 목록에 아이템 삭제
         : To - do 리스트 목록에 아이템 수정
         : To - do 리스트 목록 전체 조회
         : To - do 리스트 목록 중 특정 아이템 조회
     */

    private final TodoRepository todoRepository;
    @Transactional
    //to do 리스트 목록 전체 조회
    public List<Todolist> searchAll(){
        return this.todoRepository.findAll();
    }
    @Transactional
    //to do 리스트 목록 중 특정 아이템 조회
    public Todolist searchById(Long id){
        return this.todoRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @Transactional
    //to do 리스트 목록에 아이템 추가
    public MypageResponse.TodolistResponseDTO add(MypageRequest.TodolistRequestDTO todolistRequestDTO){
        Todolist todolist = Todolist.builder()
                .Title(todolistRequestDTO.getTitle())
                .completed(todolistRequestDTO.getCompleted())
                .build();
        return new MypageResponse.TodolistResponseDTO(todoRepository.save(todolist));
    }
    @Transactional
    // to do 리스트 목록에 아이템 수정
    public MypageResponse.TodolistResponseDTO updateById(Long id, MypageRequest.TodolistRequestDTO todolistRequestDTO){
        Todolist todolist = this.searchById(id);
        if(todolist.getTitle()!=null && todolist.getCompleted()!=null){
            todolist = new Todolist(id, todolistRequestDTO.getTitle(), todolistRequestDTO.getCompleted());
        }
        return new MypageResponse.TodolistResponseDTO(todoRepository.save(todolist));
    }
    @Transactional
    //to do 리스트 목록에 아이템 삭제
    public void deleteById(Long id){
        this.todoRepository.deleteById(id);
    }

}
