package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Team;
import lombok.Data;

@Data
public class TeamRequest {
    private String name;

    public Team toEntity() {
        return Team.builder()
                .name(this.getName())
                .build();
    }
}
