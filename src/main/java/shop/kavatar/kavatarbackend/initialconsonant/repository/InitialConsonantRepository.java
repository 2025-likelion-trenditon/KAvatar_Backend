package shop.kavatar.kavatarbackend.initialconsonant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;

public interface InitialConsonantRepository extends JpaRepository<InitialConsonant, Long>, InitialConsonantCustomRepository {
}
