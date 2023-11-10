package SOPT.server.seminar3.dto.request.member;

import SOPT.server.seminar3.domain.entity.SOPT;

public record MemberProfileUpdateRequest (
    String name,
    String nickname,
    int age,
    SOPT sopt
) {
    }