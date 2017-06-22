package systems.ab4.workshop.spots;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Rosana-Constantin on 22-Jun-17.
 */
@Repository
public interface LocationRepository extends CrudRepository<Location, Long>{
}
