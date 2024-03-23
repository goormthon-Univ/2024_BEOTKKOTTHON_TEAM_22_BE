package fairy.spring.fairy.Community.Service;

import fairy.spring.fairy.Community.Repository.Commentrepository;
import fairy.spring.fairy.Community.Repository.questionrepository;
import fairy.spring.fairy.Community.Request.CommunityRequest;
import fairy.spring.fairy.Community.Response.CommunityResponse;
import fairy.spring.fairy.Community.domain.Comment;
import fairy.spring.fairy.Community.domain.Question;
import fairy.spring.fairy.config.errors.exception.Exception400;
import fairy.spring.fairy.user.domain.User;
import fairy.spring.fairy.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final UserRepository userRepository;
    private final Commentrepository commentrepository;
    private final questionrepository questionrepository;


    //댓글 등록
    @Transactional
    public CommunityResponse.CommentResponseDTO createComment(CommunityRequest.CommentRequestDTO commentRequestDTO) {
        User user = userRepository.findByEmail(commentRequestDTO.getEmail())
                .orElseThrow(() -> new Exception400(null, "로그인을 해주세요."));
        Comment comment = Comment.builder()
                .content(commentRequestDTO.getContent())
                .type(commentRequestDTO.getType())
                .itemid(commentRequestDTO.getItemid())
                .email(commentRequestDTO.getEmail())
                .build();
        Question question  = questionrepository.findById(commentRequestDTO.getItemid()).orElseThrow(()-> new Exception400(null,"해당하는 글이없습니다."));
        int count = question.getCommentcount();
        question.setCommentcount(count+=1);

        //포인트 적립
        int currentpoint=user.getTotalpoint();
        user.setTotalpoint(currentpoint+10);
        userRepository.save(user);
        return new CommunityResponse.CommentResponseDTO(commentrepository.save(comment));
    }

    @Transactional
    //댓글 조회
    public Comment searchByIdcomment(Long comment_id) {
        return this.commentrepository.findById(comment_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Transactional
    // 댓글 수정
    public CommunityResponse.CommentResponseDTO updateByIdcomment(Long comment_id, CommunityRequest.CommentmodifyRequestDTO commentRequestDTO) {
        Comment comment = this.searchByIdcomment(comment_id);
        if (comment.getContent() != null ) {
            comment.setContent(commentRequestDTO.getContent());
        }
        return new CommunityResponse.CommentResponseDTO(commentrepository.save(comment));
    }

    @Transactional
    //댓글 삭제
    public void deleteById(Long id){
        this.commentrepository.deleteById(id);
    }
}
