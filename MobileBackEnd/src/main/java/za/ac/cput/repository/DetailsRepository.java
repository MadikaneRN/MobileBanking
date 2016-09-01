package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Details;

/**
 * Created by Scorpian on 2016-09-01.
 */
@Repository
public interface DetailsRepository extends CrudRepository<Details, Long> {
}
