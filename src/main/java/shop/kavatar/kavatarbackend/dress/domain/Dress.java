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

    private String singleDress;

    private String accessory;

    private String skinColor;

    @Builder(access = AccessLevel.PRIVATE)
    private Dress(Member member, String singleDress, String accessory, String skinColor) {
        this.member = member;
        this.singleDress = singleDress;
        this.accessory = accessory;
        this.skinColor = skinColor;
    }

    public static Dress createNewDress(Member member, String singleDress, String accessory, String skinColor) {
        return Dress.builder()
                .member(member)
                .singleDress(singleDress)
                .accessory(accessory)
                .skinColor(skinColor)
                .build();
    }

}
