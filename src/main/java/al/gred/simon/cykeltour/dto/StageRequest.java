package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Stage;
import lombok.Data;

@Data
public class StageRequest {
    private String name;
    private String description;

    public Stage toEntity() {
        return Stage.builder()
                .name(this.name)
                .description(this.description)
                .build();
    }
}
