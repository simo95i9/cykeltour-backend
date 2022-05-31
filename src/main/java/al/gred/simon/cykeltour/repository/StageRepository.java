package al.gred.simon.cykeltour.repository;

import al.gred.simon.cykeltour.entity.Rider;
import al.gred.simon.cykeltour.entity.Stage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StageRepository extends PagingAndSortingRepository<Stage, Long> {
    Stage getById(Long id);
}
