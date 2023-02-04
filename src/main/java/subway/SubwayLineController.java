package subway;

import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SubwayLineController {

    private final SubwayLineService subwayLineService;

    @PostMapping("/lines")
    public ResponseEntity<SubwayLineResponse> createLine(
        @RequestBody SubwayLineRequest subwayLineRequest) {
        SubwayLineResponse subwayLineResponse = subwayLineService.saveLine(subwayLineRequest);
        return ResponseEntity.created(URI.create("/lines/" + subwayLineResponse.getId()))
            .body(subwayLineResponse);
    }

    @GetMapping("/lines")
    public ResponseEntity<List<SubwayLineResponse>> getLineList() {
        return ResponseEntity.ok().body(subwayLineService.getLineList());
    }


}
