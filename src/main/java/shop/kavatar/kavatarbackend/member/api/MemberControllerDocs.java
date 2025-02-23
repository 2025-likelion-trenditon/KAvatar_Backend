package shop.kavatar.kavatarbackend.member.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import shop.kavatar.kavatarbackend.member.dto.request.CreateMemberRequest;
import shop.kavatar.kavatarbackend.member.dto.request.LoginRequest;
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
    ApiResponseTemplate<MemberInfoResponse> getMemberInfo(@Parameter(description = "사용자 ID") Long memberId);

    @Operation(
            summary = "포인트 내림차순 회원 조회",
            description = "포인트 내림차순으로 상위 10명의 회원을 조회합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "포인트 내림차순 회원 조회 성공"),
            @ApiResponse(responseCode = "404", description = "포인트 내림차순 회원 조회 실패")
    })
    ApiResponseTemplate<MemberInfosResponse> getMembersByPointDesc();

    @Operation(
            summary = "로그인",
            description = "이메일과 비밀번호를 입력하여 로그인합니다. 성공하면 사용자 정보를 반환합니다."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공"),
            @ApiResponse(responseCode = "400", description = "잘못된 요청 (이메일 또는 비밀번호 오류)"),
            @ApiResponse(responseCode = "401", description = "인증 실패")
    })
    ApiResponseTemplate<MemberInfoResponse> login(@Parameter(description = "로그인 요청 정보") LoginRequest request);
}
