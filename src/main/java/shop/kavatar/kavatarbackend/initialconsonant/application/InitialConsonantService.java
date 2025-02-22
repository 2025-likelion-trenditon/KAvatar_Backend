package shop.kavatar.kavatarbackend.initialconsonant.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.kavatar.kavatarbackend.initialconsonant.domain.AnswerStatus;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonantMember;
import shop.kavatar.kavatarbackend.initialconsonant.dto.request.InitialConsonantResultRequest;
import shop.kavatar.kavatarbackend.initialconsonant.dto.response.InitialConsonantResultsResponse;
import shop.kavatar.kavatarbackend.initialconsonant.repository.InitialConsonantMemberRepository;
import shop.kavatar.kavatarbackend.initialconsonant.repository.InitialConsonantRepository;
import shop.kavatar.kavatarbackend.member.domain.Member;
import shop.kavatar.kavatarbackend.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class InitialConsonantService {
    private final InitialConsonantRepository initialConsonantRepository;
    private final MemberRepository memberRepository;
    private final InitialConsonantMemberRepository initialConsonantMemberRepository;

    @Transactional(readOnly = true)
    public InitialConsonantResultsResponse playInitialConsonantGame(String category) {
        List<InitialConsonant> initialConsonants =
                initialConsonantRepository.findRandomByCategory(category, 5);

        return InitialConsonantResultsResponse.from(initialConsonants);
    }

    @Transactional
    public AnswerStatus checkAnswer(InitialConsonantResultRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));
        InitialConsonant initialConsonant = initialConsonantRepository.findById(request.initialConsonantId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 초성게임입니다."));

        if (initialConsonant.getAnswer().equals(request.userAnswer())) {
            InitialConsonantMember initialConsonantMember = InitialConsonantMember.createNewInitialConsonantMember(
                    member,
                    initialConsonant
            );
            member.addPoint(10L);
            initialConsonantMemberRepository.save(initialConsonantMember);

            return AnswerStatus.CORRECT;
        }

        return AnswerStatus.INCORRECT;
    }

    @Transactional(readOnly = true)
    public InitialConsonantResultsResponse getInitialConsonantsByMemberId(Long memberId) {
        List<InitialConsonantMember> initialConsonantMembers = initialConsonantMemberRepository.findInitialConsonantsByMemberId(memberId);
        List<InitialConsonant> initialConsonants = initialConsonantMembers.stream()
                .map(InitialConsonantMember::getInitialConsonant)
                .toList();

        return InitialConsonantResultsResponse.from(initialConsonants);
    }
}
