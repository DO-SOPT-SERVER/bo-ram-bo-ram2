package SOPT.server.seminar3.controller;

import SOPT.server.seminar3.domain.entity.Post;
import SOPT.server.seminar3.dto.request.post.PostCreateRequest;
import SOPT.server.seminar3.dto.response.post.PostGetResponse;
import SOPT.server.seminar3.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private static final String CUSTOM_AUTH_ID ="X-Auth-Id";

    //게시글 생성 조회 수정 삭제
    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
        @RequestBody PostCreateRequest request){
        String postId = postService.create(request, memberId);
        URI location = URI.create("/api/post/"+postId);
        return ResponseEntity.created(location).build();
    }



    @GetMapping("/{postId}") //멤버 아이디로 게시물 조회
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.find(postId));
    }
    @GetMapping("/all")
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }


    //세이브하지말라고하셨는데 어디지

    //복습때 코드추가

//    @GetMapping
//    public ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
//        return ResponseEntity.ok(postService.getPosts(memberId));
//    }
//    @PatchMapping("{postId}")
//    public ResponseEntity<Void> updatePost(@PathVariable Long postId, @RequestBody PostUpdateRequest request) {
//        postService.editContent(postId, request);
//        return ResponseEntity.noContent().build();
//    //여긴듯
//    }
//
//    @DeleteMapping("{postId}")
//    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
//        postService.deleteById(postId);
//        return ResponseEntity.noContent().build();
//    }
}
