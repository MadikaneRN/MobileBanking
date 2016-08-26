package za.ac.cput.services;

import java.util.List;

/**
 * Created by Scorpian on 2016-08-06.
 */

public interface Services<E, ID> {
    E create(E entity);

    E readById(ID id);

    List<E> readAll();

    E update(E entity);

    void delete(E entity);
}
