package al.gred.simon.cykeltour.api;

import al.gred.simon.cykeltour.dto.RiderRequest;
import al.gred.simon.cykeltour.dto.RiderResponse;
import al.gred.simon.cykeltour.dto.TeamRequest;
import al.gred.simon.cykeltour.dto.TeamResponse;
import al.gred.simon.cykeltour.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
@CrossOrigin
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public Page<TeamResponse> findAll(Pageable pageable) {
        return teamService.findAll(pageable);
    }

    @GetMapping(path = "/{id}")
    public TeamResponse find(@PathVariable Long id) {
        return teamService.find(id);
    }

    @PostMapping
    public TeamResponse create(@RequestBody TeamRequest body) {
        return teamService.create(body);
    }

    @PutMapping(path = "/{id}")
    public TeamResponse update(@PathVariable Long id, @RequestBody TeamRequest body) {
        return teamService.update(id, body);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) {
        teamService.delete(id);
    }


}
