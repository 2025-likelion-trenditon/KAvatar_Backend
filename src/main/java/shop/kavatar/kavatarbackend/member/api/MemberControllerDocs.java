package shop.kavatar.kavatarbackend.member.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import shop.kavatar.kavatarbackend.member.dto.request.CreateMemberRequest;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfoResponse;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfosResponse;

public interface MemberControllerDocs {

    @Operation(
            summary = "회원 가입",
            description = "새로운 회원을 생성합니다. 회원 정보를 전달하면, 새로운 회원을 생성하고 그 정보를 반환합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "회원가입 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청")
    })
    ApiResponseTemplate<MemberInfoResponse> createNewMember(CreateMemberRequest request);

    @Operation(
            summary = "회원 정보 조회",
            description = "회원 ID를 기반으로 회원의 상세 정보를 조회합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "회원 정보 조회 성공"),
            @ApiResponse(responseCode = "404", description = "회원 정보를 찾을 수 없음")
    })
    ApiResponseTemplate<MemberInfoResponse> getMemberInfo(@Parameter(description = "사용자 ID")
                                                          @PathVariable Long memberId);

    @Operation(
            summary = "포인트 내림차순 회원 조회",
            description = "포인트 내림차순으로 상위 10명의 회원을 조회합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "포인트 내림차순 회원 조회 성공"),
            @ApiResponse(responseCode = "404", description = "포인트 내림차순 회원 조회 실패")
    })
    ApiResponseTemplate<MemberInfosResponse> getMembersByPointDesc();
}
