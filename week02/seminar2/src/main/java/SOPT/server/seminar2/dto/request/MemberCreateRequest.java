package SOPT.server.seminar2.dto.request;


import SOPT.server.seminar2.domain.SOPT;
import SOPT.server.seminar2.domain.entity.Member;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
}