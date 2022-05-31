package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Stage;
import lombok.Data;

import java.util.Collection;
import java.util.stream.Stream;

@Data
public class StageResponse {
    private Long id;

    private String name;
    private String description;

    private StageResponse(Stage entity) {
        this.id = entity.getId();

        this.name = entity.getName();
        this.description = entity.getDescription();
    }

    public static Stream<StageResponse> of(Collection<Stage> entities) {
        return entities.stream().map(StageResponse::new);
    }

    public static StageResponse of(Stage entity) {
        return new StageResponse(entity);
    }
}
