package shop.kavatar.kavatarbackend.dress.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.kavatar.kavatarbackend.member.domain.Member;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dress_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Member member;

    private int singleDress;

    private int accessory;

    @Builder(access = AccessLevel.PRIVATE)
    private Dress(Member member, int singleDress, int accessory) {
        this.member = member;
        this.singleDress = singleDress;
        this.accessory = accessory;
    }

    public static Dress createNewDress(Member member, int singleDress, int accessory) {
        return Dress.builder()
                .member(member)
                .singleDress(singleDress)
                .accessory(accessory)
                .build();
    }

}
