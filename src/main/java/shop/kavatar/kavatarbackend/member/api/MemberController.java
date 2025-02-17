package shop.kavatar.kavatarbackend.member.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;
import shop.kavatar.kavatarbackend.member.application.MemberService;
import shop.kavatar.kavatarbackend.member.dto.request.CreateMemberRequest;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfoResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ApiResponseTemplate<MemberInfoResponse> createNewMember(@RequestBody CreateMemberRequest request) {
        MemberInfoResponse memberInfoResponse = memberService.createNewMember(request);

        return ApiResponseTemplate.created("회원가입 성공", memberInfoResponse);
    }

    @GetMapping("/{id}")
    public ApiResponseTemplate<MemberInfoResponse> getMemberInfo(@PathVariable Long id) {
        MemberInfoResponse memberInfoResponse = memberService.getMemberInfo(id);

        return ApiResponseTemplate.ok("회원 정보 조회 성공", memberInfoResponse);
    }
}
