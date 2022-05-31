package al.gred.simon.cykeltour.service;

import al.gred.simon.cykeltour.dto.RiderResponse;
import al.gred.simon.cykeltour.dto.TeamRequest;
import al.gred.simon.cykeltour.dto.TeamResponse;
import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Team;
import al.gred.simon.cykeltour.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public Page<TeamResponse> findAll(Pageable pageable) {
        return teamRepository.findAll(pageable).map(TeamResponse::of);
    }

    public TeamResponse find(Long id) {
        Optional<Team> team = teamRepository.findById(id);

        if (team.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return TeamResponse.of(team.get());
    }

    public TeamResponse create(TeamRequest body) {
        Team team = body.toEntity();

        return TeamResponse.of(teamRepository.save(team));
    }

    public TeamResponse update(Long id, TeamRequest body) {
        if (!teamRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Team team = teamRepository.getById(id);
        team.setName(body.getName());


        return TeamResponse.of(teamRepository.save(team));
    }

    public void delete(Long id) {
        teamRepository.deleteById(id);
    }
}
