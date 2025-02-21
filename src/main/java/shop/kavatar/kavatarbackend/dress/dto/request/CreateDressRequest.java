package shop.kavatar.kavatarbackend.dress.dto.request;

public record CreateDressRequest(
        Long memberId,
        int singleDress,
        int accessory,
        long point
) {
}
