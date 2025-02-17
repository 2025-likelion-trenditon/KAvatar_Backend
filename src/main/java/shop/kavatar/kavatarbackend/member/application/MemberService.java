package shop.kavatar.kavatarbackend.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.kavatar.kavatarbackend.global.error.exception.BadRequestException;
import shop.kavatar.kavatarbackend.member.domain.Member;
import shop.kavatar.kavatarbackend.member.dto.request.CreateMemberRequest;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfoResponse;
import shop.kavatar.kavatarbackend.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberInfoResponse createNewMember(CreateMemberRequest request) {
        if (memberRepository.existsByEmail(request.email())) {
            throw new BadRequestException("이미 사용 중인 이메일입니다: " + request.email());
        }

        Member member = Member.createNewMember(
                request.email(),
                request.password(),
                request.name(),
                request.nickname()
        );
        memberRepository.save(member);

        return MemberInfoResponse.from(member);
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse getMemberInfo(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("존재하지 않는 회원입니다: " + id));

        return MemberInfoResponse.from(member);
    }
}
