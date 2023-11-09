package SOPT.server.seminar2.service;

import SOPT.server.seminar2.domain.SOPT;
import SOPT.server.seminar2.domain.entity.Member;
import SOPT.server.seminar2.dto.request.MemberCreateRequest;
import SOPT.server.seminar2.dto.request.MemberProfileUpdateRequest;
import SOPT.server.seminar2.dto.request.MemberUpdateRequest;
import SOPT.server.seminar2.dto.response.MemberDeleteResponse;
import SOPT.server.seminar2.dto.response.MemberGetResponse;
import SOPT.server.seminar2.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    //실질적 로직 들어가는 곳

    private final MemberJpaRepository memberJpaRepository; //의존성 주입 - Repository의 기능을 쓸꺼다~

    // 멤버를 하나씩 찾아서 가져오는  로직 V1,V2,V3 세가지로 구현


    public MemberGetResponse getMemberByIdV1(Long id) {    //v1 : JPA에서 자체 내장 되어 있는 Id를 기준으로 찾아주는 findById 사용해서 member 찾기
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }


    public MemberGetResponse getMemberByIdV2(Long id) {    // v2 : Service에서는 만든것을 그냥 불러오는것
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                //회원이 없을 경우 에러 처리
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }


    public MemberGetResponse getMemberByIdV3(Long id) {    //v3 : repository/memberJpaRepository 불러와서 사용 >> 재사용 가능
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
        // V2랑 실행은 동일
    }

    //멤버 전체 다 불러내는 로직
    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()// 엔티티를 DTO의 형태로 내보내준다.
                .map(MemberGetResponse::of) //매핑을 해주겠다. 이걸 사용해서 매핑 하겠다.  - MemberGetResponse의  DTO 형태로 바꿔서
                .collect(Collectors.toList()); //List 타입으로 변경하겠다.
    }



    //멤버를 생성 로직
    @Transactional
    public String create(MemberCreateRequest request) {
        // record사용ver >> name() 이런식 사용
        Member member =  memberJpaRepository.save(Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.generation(), request.part()));
    }
    @Transactional
    public void updateMember(Long memberId, MemberUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateMember(request.name(), request.nickname(), request.age(), request.sopt() );
    }
    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        memberJpaRepository.delete(member);
    }

    @Transactional
    public MemberDeleteResponse deleteMemberById(Long id) {    //v1 : JPA에서 자체 내장 되어 있는 Id를 기준으로 찾아주는 findById 사용해서 member 찾기
        Member member = memberJpaRepository.findById(id).get();
        return MemberDeleteResponse.of(member);
    }

}