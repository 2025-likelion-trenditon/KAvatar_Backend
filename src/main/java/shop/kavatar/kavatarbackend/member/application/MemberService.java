package shop.kavatar.kavatarbackend.member.application;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.kavatar.kavatarbackend.global.error.exception.BadRequestException;
import shop.kavatar.kavatarbackend.member.domain.Member;
import shop.kavatar.kavatarbackend.member.dto.request.CreateMemberRequest;
import shop.kavatar.kavatarbackend.member.dto.request.LoginRequest;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfoResponse;
import shop.kavatar.kavatarbackend.member.dto.response.MemberInfosResponse;
import shop.kavatar.kavatarbackend.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberInfoResponse createNewMember(CreateMemberRequest request) {
        if (memberRepository.existsByEmail(request.email())) {
            throw new BadRequestException("이미 사용 중인 이메일입니다: " + request.email());
        }

        Member member = Member.createNewMember(
                request.email(),
                passwordEncoder.encode(request.password()),
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

    @Transactional(readOnly = true)
    public MemberInfosResponse getMembersByPointDesc() {
        return MemberInfosResponse.from(memberRepository.findTop10ByOrderByPointDesc());
    }

    @Transactional(readOnly = true)
    public MemberInfoResponse login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadRequestException("존재하지 않는 이메일입니다: " + request.email()));

        if (!passwordEncoder.matches(request.password(), member.getPassword())) {
            throw new BadRequestException("비밀번호가 일치하지 않습니다.");
        }

        return MemberInfoResponse.from(member);
    }
}
