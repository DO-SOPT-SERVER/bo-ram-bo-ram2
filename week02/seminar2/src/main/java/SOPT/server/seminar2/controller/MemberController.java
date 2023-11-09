package SOPT.server.seminar2.controller;


import SOPT.server.seminar2.dto.request.MemberCreateRequest;
import SOPT.server.seminar2.dto.request.MemberProfileUpdateRequest;
import SOPT.server.seminar2.dto.request.MemberUpdateRequest;
import SOPT.server.seminar2.dto.response.MemberDeleteResponse;
import SOPT.server.seminar2.dto.response.MemberGetResponse;
import SOPT.server.seminar2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    //의존성 주입을 위해 Service 선언 --> 즉 그냥 Comtroller 파일에서 Servicve 파일에 만들었던 함수들을 쓸거다~
    private final MemberService memberService;

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberGetResponse> getMemberProfileV1(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberByIdV1(memberId));
    }

    @GetMapping(value = "/{memberId}/v2", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberGetResponse> getMemberProfileV2(@PathVariable Long memberId) {
        return ResponseEntity.ok(memberService.getMemberByIdV2(memberId));
    }

    // 생성
    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody MemberCreateRequest request) {
        URI location =  URI.create(memberService.create(request));
        return ResponseEntity.created(location).build();
    }

    // 목록 조회
    @GetMapping
    public ResponseEntity<List<MemberGetResponse>> getMembersProfile() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    // sopt정보만 수정
    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberSoptInfo(@PathVariable Long memberId, @RequestBody MemberProfileUpdateRequest request) {
        memberService.updateSOPT(memberId, request);
        return ResponseEntity.noContent().build();
    }

    // 멤버정보 수정
    @PutMapping("/{memberId}")
    public ResponseEntity<Void> updateMemberInfo(@PathVariable Long memberId,
                                                 @RequestBody MemberUpdateRequest request) {
        memberService.updateMember(memberId,request);
        return ResponseEntity.noContent().build();
    }

    // 삭제
    @DeleteMapping("/{memberId}")
    public ResponseEntity deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();
    }


}