package SOPT.server.seminar2.dto.response;

import SOPT.server.seminar2.domain.SOPT;
import SOPT.server.seminar2.domain.entity.Member;

public record MemberDeleteResponse(
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) {
    public static MemberDeleteResponse of(Member member) {
        return new MemberDeleteResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
