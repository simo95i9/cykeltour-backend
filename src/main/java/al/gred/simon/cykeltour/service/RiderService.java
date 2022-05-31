package al.gred.simon.cykeltour.service;

import al.gred.simon.cykeltour.dto.RiderRequest;
import al.gred.simon.cykeltour.dto.RiderResponse;
import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Team;
import al.gred.simon.cykeltour.repository.RiderRepository;
import al.gred.simon.cykeltour.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class RiderService {
    private final RiderRepository riderRepository;
    private final TeamRepository teamRepository;

    public Page<RiderResponse> findAll(Pageable pageable) {
        return riderRepository.findAll(pageable).map(RiderResponse::of);
    }

    public RiderResponse find(Long id) {
        if (!riderRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return RiderResponse.of(riderRepository.getById(id));
    }

    public RiderResponse create(RiderRequest body) {
        Rider rider = body.toEntity();

        if (body.getTeamId() != null) {
            if (!riderRepository.existsById(body.getTeamId()))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            Team team = teamRepository.getById(body.getTeamId());
            rider.setTeam(team);
        }

        return RiderResponse.of(riderRepository.save(rider));
    }

    public RiderResponse update(Long id, RiderRequest body) {
        if (!riderRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        Rider rider = riderRepository.getById(id);
        rider.setName(body.getName());
        rider.setBirth(body.getBirth());
        rider.setCountry(body.getCountry());
        rider.setFlag(body.getFlag());

        if (body.getTeamId() != null) {
            if (!riderRepository.existsById(body.getTeamId()))
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);

            Team team = teamRepository.getById(body.getTeamId());
            rider.setTeam(team);
        }

        return RiderResponse.of(riderRepository.save(rider));
    }

    public void delete(Long id) {
        riderRepository.deleteById(id);
    }
}
