package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Account;

/**
 * Created by Scorpian on 2016-09-01.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
