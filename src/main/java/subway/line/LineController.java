package subway.line;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import subway.section.SectionRequest;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LineController {

    private final LineService lineService;

    @PostMapping("/lines")
    public ResponseEntity<LineResponse> createLine(
        @RequestBody LineRequest lineRequest) {
        LineResponse lineResponse = lineService.saveLine(lineRequest);
        return ResponseEntity.created(URI.create("/lines/" + lineResponse.getId()))
            .body(lineResponse);
    }

    @GetMapping("/lines")
    public ResponseEntity<List<LineResponse>> getSubwayLineList() {
        return ResponseEntity.ok().body(lineService.getSubwayLineList());
    }

    @GetMapping("/lines/{id}")
    public ResponseEntity<LineResponse> getSubwayLine(@PathVariable Long id) {
        return ResponseEntity.ok().body(lineService.getSubwayLine(id));
    }

    @PutMapping("/lines/{id}")
    public void modifySubwayLine(@PathVariable Long id,
                                 @RequestBody LineRequest lineRequest) {
        lineService.updateSubwayLine(id, lineRequest);
    }

    @DeleteMapping("/lines/{id}")
    public ResponseEntity<Void> deleteSubwayLine(@PathVariable Long id) {
        lineService.deleteSubwayLine(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/lines/{id}/sections")
    public ResponseEntity<Void> createSection(@PathVariable Long id,
                                              @RequestBody SectionRequest sectionRequest) {
        lineService.createSection(id, sectionRequest);
        return ResponseEntity.ok().build();
    }


}
