package shop.kavatar.kavatarbackend.dress.dto.response;

import java.util.List;
import lombok.Builder;

@Builder
public record DressesInfoResponse(
        List<DressInfoResponse> dressInfoResponses
) {
    public static DressesInfoResponse from(List<DressInfoResponse> dressInfoResponses) {
        return DressesInfoResponse.builder()
                .dressInfoResponses(dressInfoResponses)
                .build();
    }
}
