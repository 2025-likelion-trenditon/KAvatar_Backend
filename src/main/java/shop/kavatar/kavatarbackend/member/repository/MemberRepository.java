package shop.kavatar.kavatarbackend.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.kavatar.kavatarbackend.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByEmail(String email);
}
