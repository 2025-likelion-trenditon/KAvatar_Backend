package shop.kavatar.kavatarbackend.initialconsonant.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;
import shop.kavatar.kavatarbackend.initialconsonant.application.InitialConsonantService;
import shop.kavatar.kavatarbackend.initialconsonant.domain.AnswerStatus;
import shop.kavatar.kavatarbackend.initialconsonant.dto.request.InitialConsonantPlayRequest;
import shop.kavatar.kavatarbackend.initialconsonant.dto.request.InitialConsonantResultRequest;
import shop.kavatar.kavatarbackend.initialconsonant.dto.response.InitialConsonantResultsResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/initial-consonant")
public class InitialConsonantController implements InitialConsonantControllerDocs {
    private final InitialConsonantService initialConsonantService;

    @GetMapping
    @Override
    public ApiResponseTemplate<InitialConsonantResultsResponse> playInitialConsonantGame(
            @RequestParam(name = "category") String category) {
        return ApiResponseTemplate.ok("초성 퀴즈 반환 성공", initialConsonantService.playInitialConsonantGame(category));
    }

    @PostMapping
    @Override
    public ApiResponseTemplate<AnswerStatus> checkAnswer(@RequestBody InitialConsonantResultRequest request) {
        return ApiResponseTemplate.ok("정답 여부 반환 성공", initialConsonantService.checkAnswer(request));
    }

    @GetMapping("/{memberId}")
    @Override
    public ApiResponseTemplate<InitialConsonantResultsResponse> getInitialConsonantsByMemberId(
            @PathVariable Long memberId) {
        return ApiResponseTemplate.ok("사용자의 초성 퀴즈 도감 반환 성공",
                initialConsonantService.getInitialConsonantsByMemberId(memberId));
    }
}
