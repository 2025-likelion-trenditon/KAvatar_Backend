package shop.kavatar.kavatarbackend.initialconsonant.dto.response;

import java.util.List;
import lombok.Builder;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;

@Builder
public record InitialConsonantResultsResponse(
        List<InitialConsonantResultResponse> initialConsonantResults
) {
    public static InitialConsonantResultsResponse from(List<InitialConsonant> initialConsonants){
        return InitialConsonantResultsResponse.builder()
                .initialConsonantResults(initialConsonants.stream()
                        .map(InitialConsonantResultResponse::from)
                        .toList())
                .build();
    }

}
