package SOPT.server.seminar3.dto.request.member;

import SOPT.server.seminar3.domain.entity.Member;
import SOPT.server.seminar3.domain.entity.SOPT;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}

