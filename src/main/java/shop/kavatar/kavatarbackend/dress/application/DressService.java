package shop.kavatar.kavatarbackend.dress.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.kavatar.kavatarbackend.dress.domain.Dress;
import shop.kavatar.kavatarbackend.dress.dto.request.CreateDressRequest;
import shop.kavatar.kavatarbackend.dress.dto.response.DressInfoResponse;
import shop.kavatar.kavatarbackend.dress.dto.response.DressesInfoResponse;
import shop.kavatar.kavatarbackend.dress.repository.DressRepository;
import shop.kavatar.kavatarbackend.global.error.exception.BadRequestException;
import shop.kavatar.kavatarbackend.member.domain.Member;
import shop.kavatar.kavatarbackend.member.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class DressService {

    private final MemberRepository memberRepository;
    private final DressRepository dressRepository;

    @Transactional
    public DressInfoResponse createNewDress(CreateDressRequest request) {
        Member member = memberRepository.findById(request.memberId())
                .orElseThrow(() -> new BadRequestException("존재하지 않는 회원입니다: " + request.memberId()));

        Dress dress = Dress.createNewDress(
                member,
                request.singleDress(),
                request.accessory(),
                request.skinColor()
        );

        dressRepository.save(dress);

        member.addPoint(request.point());
        return DressInfoResponse.from(dress);
    }

    @Transactional(readOnly = true)
    public DressesInfoResponse getDressesInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BadRequestException("존재하지 않는 회원입니다: " + memberId));
        List<Dress> dresses = dressRepository.findAllByMember(member);

        List<DressInfoResponse> dressesInfoResponse = dresses.stream()
                .map(DressInfoResponse::from)
                .toList();

        return DressesInfoResponse.from(dressesInfoResponse);
    }

}
