package SOPT.server.seminar2.repository;


import SOPT.server.seminar2.domain.entity.Member;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {


    //Service 파일에서 예외처리하던것을 Repository파일에 정의 >> 다른곳에서도 재사용가능
    //Service 파일의 getMemberByIdV3 함수에서 사용~
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다."));
    }
    // default사용이유
    // 인터페이스의 기본 구현을 그대로 상속하므로 인터페이스에 자유롭게 새로운 메서드를 추가할 수 있게 됨
    // >> 즉 자바 api의 호환성을 유지하면서 라이브러리 변경 및 확장 가능
}