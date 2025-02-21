package shop.kavatar.kavatarbackend.initialconsonant.repository;

import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonant;
import shop.kavatar.kavatarbackend.initialconsonant.domain.InitialConsonantCategory;
import shop.kavatar.kavatarbackend.initialconsonant.domain.QInitialConsonant;

@Repository
@RequiredArgsConstructor
public class InitialConsonantCustomRepositoryImpl implements InitialConsonantCustomRepository {
    private final JPAQueryFactory queryFactory;


    @Override
    public List<InitialConsonant> findRandomByCategory(String category, int limit) {
        QInitialConsonant initialConsonant = QInitialConsonant.initialConsonant;

        return queryFactory
                .selectFrom(initialConsonant)
                .where(initialConsonant.category.eq(InitialConsonantCategory.fromString(category)))
                .orderBy(Expressions.numberTemplate(Double.class, "function('RAND')").asc())
                .limit(limit)
                .fetch();
    }
}
