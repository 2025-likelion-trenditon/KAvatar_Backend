package shop.kavatar.kavatarbackend.image.application;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import shop.kavatar.kavatarbackend.global.error.exception.BadRequestException;
import shop.kavatar.kavatarbackend.image.api.dto.response.ImageResDto;
import shop.kavatar.kavatarbackend.image.domain.Image;
import shop.kavatar.kavatarbackend.image.domain.repository.ImageRepository;
import shop.kavatar.kavatarbackend.member.domain.Member;
import shop.kavatar.kavatarbackend.member.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageService {

    @Value("${spring.cloud.gcp.storage.credentials.location}")
    private String keyFileName;

    @Value("${spring.cloud.gcp.storage.bucket}")
    private String bucketName;

    private final MemberRepository memberRepository;
    private final ImageRepository imageRepository;

    @Transactional
    public ImageResDto upload(Long memberId, MultipartFile multipartFile)
            throws IOException {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new BadRequestException("존재하지 않는 회원입니다: " + memberId));

        String uuid = getUuid();
        Storage storage = getStorage();

        String filePath = getFilePath(member, uuid);
        String imgUrl = getImgUrl(filePath);

        storageSave(multipartFile, filePath, storage);
        Image image = imageSave(imgUrl, member);

        member.updateProfileImageUrl(image.getConvertImageUrl());
        return ImageResDto.from(image);
    }

    private static String getUuid() {
        return UUID.randomUUID().toString();
    }

    private Storage getStorage() throws IOException {
        InputStream keyFile = ResourceUtils.getURL(keyFileName).openStream();

        return StorageOptions.newBuilder()
                .setCredentials(GoogleCredentials.fromStream(keyFile))
                .build()
                .getService();
    }

    private static String getFilePath(Member member, String uuid) {
        return "kavatar/" + member.getId() + "/" + uuid;
    }

    private String getImgUrl(String filePath) {
        return "https://storage.googleapis.com/" + bucketName + "/" + filePath;
    }

    private void storageSave(MultipartFile file, String filePath, Storage storage) throws IOException {
        BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, filePath)
                .setContentType(file.getContentType())
                .build();

        storage.create(blobInfo, file.getInputStream());
    }

    private Image imageSave(String imgUrl, Member member) {
        Image image = Image.builder()
                .convertImageUrl(imgUrl)
                .member(member)
                .build();

        return imageRepository.save(image);
    }

}
