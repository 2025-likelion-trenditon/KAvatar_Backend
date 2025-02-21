package shop.kavatar.kavatarbackend.initialconsonant.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InitialConsonant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private InitialConsonantCategory category;

    private String question;

    private String answer;

    private String explanation;

    @Builder(access = AccessLevel.PRIVATE)
    public InitialConsonant(InitialConsonantCategory category, String question, String answer, String explanation) {
        this.category = category;
        this.question = question;
        this.answer = answer;
        this.explanation = explanation;
    }
}
