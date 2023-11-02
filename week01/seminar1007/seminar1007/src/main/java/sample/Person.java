package sample;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Person {
    private String lastName;
    private String firstName;

    //lombok
    //다 안넣고 @Gatter @Setter 어노테이션 달면 다른 클래스에서 불러올 수 있음
    //builder 패턴
}