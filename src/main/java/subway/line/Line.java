package subway.line;


import lombok.Getter;
import lombok.NoArgsConstructor;
import subway.section.Section;
import subway.station.Station;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Line {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 31, nullable = false)
    private String name;
    @Column(length = 31, nullable = false)
    private String color;
    @JoinColumn(name = "up_station_id", nullable = false)
    @OneToOne
    private Station upStation;
    @JoinColumn(name = "down_station_id", nullable = false)
    @OneToOne
    private Station downStation;
    @Column(nullable = false)
    private Integer distance;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Section> sectionList;


    public Line(String name, String color, Station upStationId,
                Station downStationId, Integer distance) {
        this.name = name;
        this.color = color;
        this.upStation = upStationId;
        this.downStation = downStationId;
        this.distance = distance;
    }

    public void update(Long id, LineRequest lineRequest) {
        this.id = id;
        this.name = lineRequest.getName();
        this.color = lineRequest.getColor();
    }

    public void createSection(Station upStation, Station downStation, Integer distance) {
        Section section = Section.createSection(this, upStation, downStation, distance);
        this.sectionList.add(section);
    }
}
