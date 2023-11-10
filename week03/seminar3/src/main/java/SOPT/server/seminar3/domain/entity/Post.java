package SOPT.server.seminar3.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post")   //db랑 class 이름 다르게할 때 사용
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;

    @Column(columnDefinition = "TEXT")  //이렇게 안해주면 varchar로 저장됨
    //varchar vs text
    private String content; //게시글 내용 >> 일반적으로 너무김

    @ManyToOne(fetch = FetchType.LAZY)  //1대다에선 다쪽이 연관관계 주인
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}