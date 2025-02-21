package shop.kavatar.kavatarbackend.member.dto.request;

public record CreateMemberRequest(
        String email,
        String password,
        String name,
        String nickname
) {
}
