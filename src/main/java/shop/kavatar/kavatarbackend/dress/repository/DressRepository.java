package shop.kavatar.kavatarbackend.dress.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import shop.kavatar.kavatarbackend.dress.domain.Dress;
import shop.kavatar.kavatarbackend.member.domain.Member;

public interface DressRepository extends JpaRepository<Dress, Long> {

    List<Dress> findAllByMember(Member member);
}
