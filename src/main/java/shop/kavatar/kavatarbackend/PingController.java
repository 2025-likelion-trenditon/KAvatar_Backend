package shop.kavatar.kavatarbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;

@RestController
public class PingController {

    @GetMapping("/ping")
    public ApiResponseTemplate<String> ping() {
        return ApiResponseTemplate.ok("pong");
    }

}
