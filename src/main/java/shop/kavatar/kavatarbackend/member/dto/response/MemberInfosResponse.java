package shop.kavatar.kavatarbackend.member.dto.response;

import java.util.List;
import lombok.Builder;
import shop.kavatar.kavatarbackend.member.domain.Member;

@Builder
public record MemberInfosResponse(
        List<MemberInfoResponse> memberInfoResponses
) {
    public static MemberInfosResponse from(List<Member> members) {
        return MemberInfosResponse.builder()
                .memberInfoResponses(members.stream()
                        .map(MemberInfoResponse::from)
                        .toList()
                )
                .build();
    }
}
