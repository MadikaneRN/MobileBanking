package za.ac.cput.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;


/**
 * Created by Scorpian on 2016-08-06.
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{


}
