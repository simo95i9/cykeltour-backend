package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Result;
import lombok.Data;

import java.time.Duration;

@Data
public class ResultRequest {
    private Duration time;
    private Double mountainPoints;
    private Double flatPoints;

    private Long riderId;
    private Long stageId;

    public Result toEntity() {
        return Result.builder()
                .time(this.time)
                .mountainPoints(this.mountainPoints)
                .flatPoints(this.flatPoints)
                .build();
    }
}
