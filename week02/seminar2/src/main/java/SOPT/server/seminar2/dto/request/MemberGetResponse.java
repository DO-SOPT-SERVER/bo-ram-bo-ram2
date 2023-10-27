package SOPT.server.seminar2.dto.request;

import SOPT.server.seminar2.entity.Member;
import SOPT.server.seminar2.entity.SOPT;

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

