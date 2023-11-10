package SOPT.server.seminar3.dto.request.member;
import SOPT.server.seminar3.domain.entity.SOPT;


public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
}
//record를 쓰면 .name()형식으로 바로 가져올 수 있음

//@Data
//public class MemberCreateRequest{
//    private String name;
//    private String nickname;
//    private int age;
//    private SOPT sopt;
//} >> 기본적으로 많이 쓰는 방식 나중에 요소에 접근하려면 .getName()이런식으로 접근!