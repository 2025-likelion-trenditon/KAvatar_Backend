package shop.kavatar.kavatarbackend.member.dto.response;

import lombok.Builder;
import shop.kavatar.kavatarbackend.member.domain.Member;

@Builder
public record MemberInfoResponse(
        Long id,
        String email,
        String profileImageUrl,
        String name,
        String nickname,
        long point
) {
    public static MemberInfoResponse from(Member member) {
        return MemberInfoResponse.builder()
                .id(member.getId())
                .email(member.getEmail())
                .profileImageUrl(member.getProfileImageUrl())
                .name(member.getName())
                .nickname(member.getNickname())
                .point(member.getPoint())
                .build();
    }
}
