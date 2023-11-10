package SOPT.server.seminar3.service;

import SOPT.server.seminar3.dto.request.post.PostCreateRequest;
import SOPT.server.seminar3.domain.entity.Member;
import SOPT.server.seminar3.domain.entity.Post;
import SOPT.server.seminar3.repository.MemberJpaRepository;
import SOPT.server.seminar3.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public  String create(PostCreateRequest request, Long memberId){
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .build(); // 비영속상태

        Post savePost = postJpaRepository.save(post);
        return savePost.getPostId().toString();
    }
}
