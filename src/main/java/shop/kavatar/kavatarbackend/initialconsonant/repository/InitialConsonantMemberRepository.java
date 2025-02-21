package shop.kavatar.kavatarbackend.initialconsonant.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.kavatar.kavatarbackend.initialconsonant.application.InitialConsonantMember;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;

public interface InitialConsonantMemberRepository extends JpaRepository<InitialConsonantMember, Long> {
    List<InitialConsonantMember> findInitialConsonantsByMemberId(Long memberId);
}

