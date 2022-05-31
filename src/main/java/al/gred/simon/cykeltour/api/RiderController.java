package al.gred.simon.cykeltour.api;

import al.gred.simon.cykeltour.dto.RiderRequest;
import al.gred.simon.cykeltour.dto.RiderResponse;
import al.gred.simon.cykeltour.service.RiderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/riders")
@CrossOrigin
@RequiredArgsConstructor
public class RiderController {
    private final RiderService riderService;

    @GetMapping
    public Page<RiderResponse> findAll(Pageable pageable) {
        return riderService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public RiderResponse find(@PathVariable Long id) {
        return riderService.find(id);
    }

    @PostMapping
    public RiderResponse create(@RequestBody RiderRequest body) {
        return riderService.create(body);
    }

    @PutMapping(path = "/{id}")
    public RiderResponse update(@PathVariable Long id, @RequestBody RiderRequest body) {
        return riderService.update(id, body);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        riderService.delete(id);
    }
}
