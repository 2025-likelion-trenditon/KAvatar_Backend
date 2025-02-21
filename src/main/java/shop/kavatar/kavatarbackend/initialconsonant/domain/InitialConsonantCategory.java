package shop.kavatar.kavatarbackend.initialconsonant.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum InitialConsonantCategory {
    FOOD("음식"),
    REGION("지역"),
    TRADITIONAL_GAME("전통놀이"),
    ;

    private final String value;

    public static InitialConsonantCategory fromString(String category) {
        return InitialConsonantCategory.valueOf(category.toUpperCase().replace("-", "_"));
    }
}
