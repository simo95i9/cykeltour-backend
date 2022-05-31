package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Rider;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Data
public class RiderResponse {
    private Long id;

    private String name;
    private LocalDate birth;

    private String country;
    private String flag;

    private Long teamId;
    private String teamName;

    private RiderResponse(Rider entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.country = entity.getCountry();
        this.flag = entity.getFlag();

        this.teamId = entity.getTeam() == null ? null : entity.getTeam().getId();
        this.teamName = entity.getTeam() == null ? null : entity.getTeam().getName();
    }

    public static Stream<RiderResponse> of(Collection<Rider> entities) {
        return entities.stream().map(RiderResponse::new);
    }

    public static RiderResponse of(Rider entity) {
        return new RiderResponse(entity);
    }
}
