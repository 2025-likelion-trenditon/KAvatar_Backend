package shop.kavatar.kavatarbackend.initialconsonant.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.kavatar.kavatarbackend.global.domain.BaseTimeEntity;
import shop.kavatar.kavatarbackend.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InitialConsonantMember extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "initial_consonant_id")
    private InitialConsonant initialConsonant;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder(access = AccessLevel.PRIVATE)
    private InitialConsonantMember(Member member, InitialConsonant initialConsonant) {
        this.member = member;
        this.initialConsonant = initialConsonant;
    }

    public static InitialConsonantMember createNewInitialConsonantMember(Member member, InitialConsonant initialConsonant) {
        return InitialConsonantMember.builder()
                .member(member)
                .initialConsonant(initialConsonant)
                .build();
    }
}
