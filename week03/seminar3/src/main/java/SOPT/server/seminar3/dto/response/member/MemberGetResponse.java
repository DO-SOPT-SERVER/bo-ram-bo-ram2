package SOPT.server.seminar3.dto.response.member;

import SOPT.server.seminar3.domain.entity.SOPT;
import SOPT.server.seminar3.domain.entity.Member;

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

