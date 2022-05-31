package al.gred.simon.cykeltour.api;

import al.gred.simon.cykeltour.dto.ResultRequest;
import al.gred.simon.cykeltour.dto.ResultResponse;
import al.gred.simon.cykeltour.dto.RiderRequest;
import al.gred.simon.cykeltour.dto.RiderResponse;
import al.gred.simon.cykeltour.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
@CrossOrigin
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @GetMapping
    public Page<ResultResponse> findAll(Pageable pageable) {
        return resultService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public ResultResponse find(@PathVariable Long id) {
        return resultService.find(id);
    }

    @GetMapping(params = "stageId")
    public Page<ResultResponse> findAllByStageId(Pageable pageable, @RequestParam Long stageId) {
        return resultService.findAllByStageId(pageable, stageId);
    }

    @GetMapping(params = "riderId")
    public Page<ResultResponse> findAllByRiderId(Pageable pageable, @RequestParam Long riderId) {
        return resultService.findAllByRiderId(pageable, riderId);
    }

    @PostMapping
    public ResultResponse create(@RequestBody ResultRequest body) {
        return resultService.create(body);
    }

    @PutMapping(path = "/{id}")
    public ResultResponse update(@PathVariable Long id, @RequestBody ResultRequest body) {
        return resultService.update(id, body);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        resultService.delete(id);
    }
}
