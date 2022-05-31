package al.gred.simon.cykeltour.dto;

import al.gred.simon.cykeltour.entity.Result;
import lombok.Data;

import java.time.Duration;
import java.util.Collection;
import java.util.stream.Stream;

@Data
public class ResultResponse {
    private Long id;

    private Duration time;
    private Double mountainPoints;
    private Double flatPoints;

    private RiderResponse rider;
    private Long stageId;

    private ResultResponse(Result entity) {
        this.id = entity.getId();
        this.time = entity.getTime();
        this.mountainPoints = entity.getMountainPoints();
        this.flatPoints = entity.getFlatPoints();

        this.rider = entity.getRider() == null ? null : RiderResponse.of(entity.getRider());

        this.stageId = entity.getStage() == null ? null : entity.getStage().getId();
    }

    public static Stream<ResultResponse> of(Collection<Result> entities) {
        return entities.stream().map(ResultResponse::new);
    }

    public static ResultResponse of(Result entity) {
        return new ResultResponse(entity);
    }
}
