package SOPT.server.seminar3.domain.entity;

import SOPT.server.seminar3.enums.Part;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SOPT {
    private int generation;

    @Enumerated(value = STRING)
    private Part part;  //sopt 엔티티에서 필요한 enum
}