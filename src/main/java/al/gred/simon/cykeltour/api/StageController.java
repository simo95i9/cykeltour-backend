package al.gred.simon.cykeltour.api;

import al.gred.simon.cykeltour.dto.StageRequest;
import al.gred.simon.cykeltour.dto.StageResponse;
import al.gred.simon.cykeltour.service.StageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stages")
@CrossOrigin
@RequiredArgsConstructor
public class StageController {
    private final StageService stageService;

    @GetMapping
    public Page<StageResponse> findAll(Pageable pageable) {
        return stageService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public StageResponse find(@PathVariable Long id) {
        return stageService.find(id);
    }

    @PostMapping
    public StageResponse create(@RequestBody StageRequest body) {
        return stageService.create(body);
    }

    @PutMapping(path = "/{id}")
    public StageResponse update(@PathVariable Long id, @RequestBody StageRequest body) {
        return stageService.update(id, body);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        stageService.delete(id);
    }
}
