package al.gred.simon.cykeltour.repository;

import al.gred.simon.cykeltour.entity.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ResultRepository extends PagingAndSortingRepository<Result, Long> {
    Result getById(Long id);
    Page<Result> getByStage_Id(Long stageId, Pageable pageable);
    Page<Result> getByRider_Id(Long riderId, Pageable pageable);
}
