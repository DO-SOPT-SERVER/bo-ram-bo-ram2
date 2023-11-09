package SOPT.server.seminar2.dto.request;


import SOPT.server.seminar2.enums.Part;
import SOPT.server.seminar2.domain.SOPT;

public record MemberProfileUpdateRequest(
        int generation,
        Part part
) {

}
