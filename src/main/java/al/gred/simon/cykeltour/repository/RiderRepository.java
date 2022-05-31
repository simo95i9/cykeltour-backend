package al.gred.simon.cykeltour.repository;

import al.gred.simon.cykeltour.entity.Rider;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderRepository extends PagingAndSortingRepository<Rider, Long> {
    Rider getById(Long id);
}
