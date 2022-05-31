package al.gred.simon.cykeltour.service;

import al.gred.simon.cykeltour.dto.ResultRequest;
import al.gred.simon.cykeltour.dto.ResultResponse;
import al.gred.simon.cykeltour.entity.Result;
import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Stage;
import al.gred.simon.cykeltour.repository.ResultRepository;
import al.gred.simon.cykeltour.repository.RiderRepository;
import al.gred.simon.cykeltour.repository.StageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final RiderRepository riderRepository;
    private final StageRepository stageRepository;

    public Page<ResultResponse> findAll(Pageable pageable) {
        return resultRepository.findAll(pageable).map(ResultResponse::of);
    }

    public ResultResponse find(Long id) {
        if (resultRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return ResultResponse.of(resultRepository.getById(id));
    }

    public ResultResponse create(ResultRequest body) {
        if (!riderRepository.existsById(body.getRiderId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if (!stageRepository.existsById(body.getStageId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Rider rider = riderRepository.getById(body.getRiderId());
        Stage stage = stageRepository.getById(body.getStageId());

        Result result = body.toEntity();
        result.setRider(rider);
        result.setStage(stage);

        return ResultResponse.of(resultRepository.save(result));
    }

    public ResultResponse update(Long id, ResultRequest body) {
        if (!resultRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if (!riderRepository.existsById(body.getRiderId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        if (!stageRepository.existsById(body.getStageId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Result result = resultRepository.getById(id);

        result.setTime(body.getTime());
        result.setMountainPoints(body.getMountainPoints());
        result.setFlatPoints(body.getFlatPoints());

        Rider rider = riderRepository.getById(body.getRiderId());
        Stage stage = stageRepository.getById(body.getStageId());

        result.setRider(rider);
        result.setStage(stage);

        return ResultResponse.of(resultRepository.save(result));
    }

    public void delete(Long id) {
        resultRepository.deleteById(id);
    }

    public Page<ResultResponse> findAllByStageId(Pageable pageable, Long stageId) {
        return resultRepository.getByStage_Id(stageId, pageable).map(ResultResponse::of);
    }

    public Page<ResultResponse> findAllByRiderId(Pageable pageable, Long riderId) {
        return resultRepository.getByRider_Id(riderId, pageable).map(ResultResponse::of);
    }
}
