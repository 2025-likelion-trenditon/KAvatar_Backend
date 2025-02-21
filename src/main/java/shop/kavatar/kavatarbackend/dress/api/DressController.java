package shop.kavatar.kavatarbackend.dress.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.kavatar.kavatarbackend.dress.application.DressService;
import shop.kavatar.kavatarbackend.dress.dto.request.CreateDressRequest;
import shop.kavatar.kavatarbackend.dress.dto.response.DressInfoResponse;
import shop.kavatar.kavatarbackend.dress.dto.response.DressesInfoResponse;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dress")
public class DressController implements DressControllerDocs {

    private final DressService dressService;

    @PostMapping
    public ApiResponseTemplate<DressInfoResponse> createNewDress(@RequestBody CreateDressRequest createDressRequest) {
        DressInfoResponse dressInfoResponse = dressService.createNewDress(createDressRequest);

        return ApiResponseTemplate.created("옷 입히기 저장 성공", dressInfoResponse);
    }

    @GetMapping("/{memberId}")
    public ApiResponseTemplate<DressesInfoResponse> getDressesInfo(@PathVariable Long memberId) {
        DressesInfoResponse dressesInfoResponse = dressService.getDressesInfo(memberId);

        return ApiResponseTemplate.ok("옷 입히기 게임 정보 리스트 조회 성공", dressesInfoResponse);
    }

}
