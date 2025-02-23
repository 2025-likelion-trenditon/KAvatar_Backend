package shop.kavatar.kavatarbackend.image.api;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;
import shop.kavatar.kavatarbackend.image.api.dto.response.ImageResDto;
import shop.kavatar.kavatarbackend.image.application.ImageService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController implements ImageControllerDocs {

    private final ImageService imageService;

    @PostMapping(value = "/upload/{memberId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponseTemplate<ImageResDto> imageUpload(@PathVariable Long memberId,
                                                        @RequestPart("multipartFile") MultipartFile multipartFile)
            throws IOException {
        return ApiResponseTemplate.ok("이미지 업로드", imageService.upload(memberId, multipartFile));
    }

}
