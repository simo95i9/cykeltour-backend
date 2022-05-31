package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Rider;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RiderRequest {
    private String name;
    private LocalDate birth;
    private String country;
    private String flag;
    private Long teamId;

    public Rider toEntity() {
        return Rider.builder()
                .name(this.name)
                .birth(this.birth)
                .country(this.country)
                .flag(this.flag)
                .build();
    }

}
