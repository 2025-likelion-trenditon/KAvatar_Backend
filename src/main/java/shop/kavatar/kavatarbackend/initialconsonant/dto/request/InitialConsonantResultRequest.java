package shop.kavatar.kavatarbackend.initialconsonant.dto.request;

public record InitialConsonantResultRequest(
        Long memberId,
        Long initialConsonantId,
        String userAnswer
) {
}
