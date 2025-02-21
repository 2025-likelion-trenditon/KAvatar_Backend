package shop.kavatar.kavatarbackend.initialconsonant.repository;

import java.util.List;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;

public interface InitialConsonantCustomRepository {
    List<InitialConsonant> findRandomByCategory(String category, int limit);
}
