package shop.kavatar.kavatarbackend.dress.dto.request;

public record CreateDressRequest(
        Long memberId,
        String singleDress,
        String accessory,
        long point
) {
}
