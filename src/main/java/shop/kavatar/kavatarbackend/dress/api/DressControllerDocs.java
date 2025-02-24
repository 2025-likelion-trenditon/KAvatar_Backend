package shop.kavatar.kavatarbackend.dress.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import shop.kavatar.kavatarbackend.dress.dto.request.CreateDressRequest;
import shop.kavatar.kavatarbackend.dress.dto.response.DressInfoResponse;
import shop.kavatar.kavatarbackend.dress.dto.response.DressesInfoResponse;
import shop.kavatar.kavatarbackend.global.template.ApiResponseTemplate;

public interface DressControllerDocs {

    @Operation(summary = "옷 입히기 저장하기", description = "옷 입히기 게임을 저장합니다. 옷 정보가 있습니다."
            + "memberId: 사용자 아이디, singleDress: 한 벌 의상, accessory: 액세서리, skinColor: 피부색, point: 포인트")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
    })
    ApiResponseTemplate<DressInfoResponse> createNewDress(@RequestBody CreateDressRequest createDressRequest);

    @Operation(summary = "옷 입히기 게임 정보 리스트 조회", description = "사용자의 옷 입히기 게임 정보 리스트를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "성공"),
    })
    ApiResponseTemplate<DressesInfoResponse> getDressesInfo(@PathVariable Long memberId);
}
