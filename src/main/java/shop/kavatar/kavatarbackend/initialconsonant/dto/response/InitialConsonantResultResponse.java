package shop.kavatar.kavatarbackend.initialconsonant.dto.response;

import lombok.Builder;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;

@Builder
public record InitialConsonantResultResponse(
        Long initialConsonantId,
        String question,
        String answer,
        String explanation
) {
    public static InitialConsonantResultResponse from(InitialConsonant initialConsonant) {
        return InitialConsonantResultResponse.builder()
                .initialConsonantId(initialConsonant.getId())
                .question(initialConsonant.getQuestion())
                .answer(initialConsonant.getAnswer())
                .explanation(initialConsonant.getExplanation())
                .build();
    }
}
