package al.gred.simon.cykeltour.repository;

import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Team;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends PagingAndSortingRepository<Team, Long> {
    Team getById(Long id);
}
