package shop.kavatar.kavatarbackend.dress.dto.response;

import lombok.Builder;
import shop.kavatar.kavatarbackend.dress.domain.Dress;

@Builder
public record DressInfoResponse(
        int singleDress,
        int accessory
) {
    public static DressInfoResponse from(Dress dress) {
        return DressInfoResponse.builder()
                .singleDress(dress.getSingleDress())
                .accessory(dress.getAccessory())
                .build();
    }
}
