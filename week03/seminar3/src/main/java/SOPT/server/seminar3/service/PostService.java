package SOPT.server.seminar3.service;

import SOPT.server.seminar3.domain.entity.Member;
import SOPT.server.seminar3.domain.entity.Post;
import SOPT.server.seminar3.dto.request.post.PostCreateRequest;
import SOPT.server.seminar3.dto.response.post.PostGetResponse;
import SOPT.server.seminar3.repository.MemberJpaRepository;
import SOPT.server.seminar3.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        memberJpaRepository.findByIdOrThrow(memberId);
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .member(member)
                .build();
        Post savedPost = postJpaRepository.save(post);
        return savedPost.getPostId().toString();
    }


    public PostGetResponse find(Long postId) {
        Post post = postJpaRepository.findByIdOrThrow(postId);
        return new PostGetResponse(post.getTitle(), post.getContent(), post.getMember().getNickname());
    }

    public List<Post> findAll() {

        return postJpaRepository.findAll();
    }

//    @Transactional
//    public void editContent(Long postId, PostUpdateRequest request) {
//        Post post = postJpaRepository.findById(postId)
//                .orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
//        post.updateContent(request.content());
//    }
//
//    @Transactional
//    public void deleteById(Long postId) {
//        Post post = postJpaRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("해당하는 게시글이 없습니다."));
//        postJpaRepository.delete(post);
//    }
//
//    public List<PostGetResponse> getPosts(Long memberId) {
//        return postJpaRepository.findAllByMemberId(memberId)
//                .stream()
//                .map(post -> PostGetResponse.of(post))
//                .toList();
//    }

}
