/*
커뮤니티 기능 구현 후에 작성 글 조회, 작성 댓글 조회 구현


package fairy.spring.fairy.user.service;

import fairy.spring.fairy.user.domain.Post;
import fairy.spring.fairy.user.repository.PostRepository;
import fairy.spring.fairy.user.request.MypageRequest;
import fairy.spring.fairy.user.response.MypageResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
public MypageResponse.PostResponseDTO viewpost(MypageRequest.PostRequestDTO postRequestDTO){
    Post post = Post.builder()
            .postContent(postRequestDTO.getPastContent())
            .postTitle(postRequestDTO.getPostTitle())
            .category(postRequestDTO.getCategory())
            .createdAt(postRequestDTO.getCreatedAt())
            .build();
    post = postRepository.save(post);
    return new MypageResponse.MypageinfoResponseDTO(post.getPostContent(), post.getCountcomment(), post.getPostTitle(),post.getCategory(),post.getCreatedAt(),post.getCountcomment(),post.getScrap());
}

}
 */
