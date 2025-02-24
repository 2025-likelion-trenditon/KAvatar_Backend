package shop.kavatar.kavatarbackend.dress.dto.response;

import lombok.Builder;
import shop.kavatar.kavatarbackend.dress.domain.Dress;

@Builder
public record DressInfoResponse(
        String singleDress,
        String accessory,
        String skinColor
) {
    public static DressInfoResponse from(Dress dress) {
        return DressInfoResponse.builder()
                .singleDress(dress.getSingleDress())
                .accessory(dress.getAccessory())
                .skinColor(dress.getSkinColor())
                .build();
    }
}
