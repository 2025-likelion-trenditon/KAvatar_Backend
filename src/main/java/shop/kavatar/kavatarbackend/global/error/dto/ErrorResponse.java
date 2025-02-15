package shop.kavatar.kavatarbackend.global.error.dto;

import lombok.Builder;

@Builder
public record ErrorResponse(
        String message
) {
   public static ErrorResponse of(String message) {
        return ErrorResponse.builder()
                .message(message)
                .build();
    }
}
