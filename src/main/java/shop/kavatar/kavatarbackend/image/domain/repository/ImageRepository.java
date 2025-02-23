package shop.kavatar.kavatarbackend.image.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.kavatar.kavatarbackend.image.domain.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
