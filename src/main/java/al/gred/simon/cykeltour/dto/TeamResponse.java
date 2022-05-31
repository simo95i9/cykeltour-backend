package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Team;
import lombok.Data;

import java.util.Collection;
import java.util.stream.Stream;

@Data
public class TeamResponse {
    private Long id;
    private String name;
    private Stream<RiderResponse> riders;

    private TeamResponse(Team entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.riders = entity.getRiders() == null ? null : RiderResponse.of(entity.getRiders());
    }

    public static Stream<TeamResponse> of(Collection<Team> entities) {
        return entities.stream().map(TeamResponse::new);
    }

    public static TeamResponse of(Team entity) {
        return new TeamResponse(entity);
    }
}
