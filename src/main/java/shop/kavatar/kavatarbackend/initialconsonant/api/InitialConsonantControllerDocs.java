package shop.kavatar.kavatarbackend.initialconsonant.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import shop.kavatar.kavatarbackend.initialconsonant.domain.AnswerStatus;
import shop.kavatar.kavatarbackend.initialconsonant.dto.request.InitialConsonantResultRequest;
import shop.kavatar.kavatarbackend.initialconsonant.dto.response.InitialConsonantResultsResponse;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonantCategory;

public interface InitialConsonantControllerDocs {

    @Operation(
            summary = "초성 게임 시작",
            description = "주어진 카테고리로 초성 게임을 시작합니다. 카테고리를 전달하면, 게임에 사용할 문제들을 반환합니다."
                    + " 카테고리 값은 아래와 같습니다: "
                    + "1. 음식 (food) - 음식과 관련된 문제\n"
                    + "2. 지역 (region) - 지역과 관련된 문제\n"
                    + "3. 전통놀이 (traditional-game) - 전통놀이와 관련된 문제"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 카테고리")
    })
    ApiResponseTemplate<InitialConsonantResultsResponse> playInitialConsonantGame(
            @Parameter(description = "초성 게임 카테고리")
            @RequestParam(name = "category") String category);

    @Operation(summary = "초성 게임 정답 확인", description = "사용자가 제출한 정답을 확인하고, 맞았는지 틀렸는지 상태를 반환합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "정답 확인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청"),
            @ApiResponse(responseCode = "404", description = "게임 정보 없음")
    })
    ApiResponseTemplate<AnswerStatus> checkAnswer(@RequestBody InitialConsonantResultRequest request);

    @Operation(
            summary = "사용자의 초성 퀴즈 도감 조회",
            description = "주어진 사용자 ID에 해당하는 초성 퀴즈 도감을 반환합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 사용자 ID"),
            @ApiResponse(responseCode = "404", description = "사용자 초성 퀴즈 도감 없음")
    })
    ApiResponseTemplate<InitialConsonantResultsResponse> getInitialConsonantsByMemberId(
            @Parameter(description = "사용자 ID")
            @PathVariable Long memberId);
}
