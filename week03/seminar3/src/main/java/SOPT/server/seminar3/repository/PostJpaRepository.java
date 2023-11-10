package SOPT.server.seminar3.repository;

import SOPT.server.seminar3.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
