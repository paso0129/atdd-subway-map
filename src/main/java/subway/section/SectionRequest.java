package subway.section;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class SectionRequest {

    private Long upStationId;
    private Long downStationId;
    private Integer distance;

//    public SectionRequest(Long upStationId, Long downStationId, Integer distance) {
//        this.upStationId = upStationId;
//        this.downStationId = downStationId;
//        this.distance = distance;
//    }

}
