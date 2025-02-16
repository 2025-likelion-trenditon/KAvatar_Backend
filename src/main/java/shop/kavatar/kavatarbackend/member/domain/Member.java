package shop.kavatar.kavatarbackend.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column(name = "profile_image_url")
    private String profileImageUrl;

    private String password;

    private String name;

    private String nickname;

    private long point;

    @Builder(access = AccessLevel.PRIVATE)
    public Member(String email, String profileImageUrl, String password, String name, String nickname,
                  long point) {
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.point = point;
    }

    public static Member createNewMember(String email,
                                  String password,
                                  String name,
                                  String nickname) {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .point(0L)
                .build();
    }
}
