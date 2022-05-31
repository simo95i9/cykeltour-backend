package al.gred.simon.cykeltour.service;

import al.gred.simon.cykeltour.dto.StageRequest;
import al.gred.simon.cykeltour.dto.StageResponse;
import al.gred.simon.cykeltour.entity.Stage;
import al.gred.simon.cykeltour.repository.StageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class StageService {
    private final StageRepository stageRepository;

    public Page<StageResponse> findAll(Pageable pageable) {
        return stageRepository.findAll(pageable).map(StageResponse::of);
    }

    public StageResponse find(Long id) {
        if (!stageRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return StageResponse.of(stageRepository.getById(id));
    }

    public StageResponse create(StageRequest body) {
        Stage stage = body.toEntity();

        return StageResponse.of(stageRepository.save(stage));
    }

    public StageResponse update(Long id, StageRequest body) {
        if (!stageRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Stage stage = stageRepository.getById(id);

        stage.setName(body.getName());
        stage.setDescription(body.getDescription());

        return StageResponse.of(stageRepository.save(stage));
    }

    public void delete(Long id) {
        stageRepository.deleteById(id);
    }
}
