package shop.kavatar.kavatarbackend.image.api.dto.response;

import lombok.Builder;
import shop.kavatar.kavatarbackend.image.domain.Image;

@Builder
public record ImageResDto(
        String convertImageUrl
) {
    public static ImageResDto from(Image image) {
        return ImageResDto.builder()
                .convertImageUrl(image.getConvertImageUrl())
                .build();
    }
}
