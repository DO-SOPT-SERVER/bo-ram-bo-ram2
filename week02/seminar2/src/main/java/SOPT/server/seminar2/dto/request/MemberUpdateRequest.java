package SOPT.server.seminar2.dto.request;
import SOPT.server.seminar2.domain.SOPT;
import SOPT.server.seminar2.domain.entity.Member;

public record MemberUpdateRequest (
        String name,
        String nickname,
        int age,
        SOPT sopt
){
    public static MemberUpdateRequest of(Member member) {
        return new MemberUpdateRequest(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}
