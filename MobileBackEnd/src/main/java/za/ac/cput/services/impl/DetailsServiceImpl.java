package za.ac.cput.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Details;
import za.ac.cput.repository.DetailsRepository;
import za.ac.cput.services.DetailsService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scorpian on 2016-09-01.
 */

@Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    DetailsRepository repository;


    @Override
    public Details create(Details entity)
    {
        return repository.save(entity);
    }

    @Override
    public List<Details> readAll()
    {
        List<Details> clientsList = new ArrayList<Details>();
        Iterable<Details> clients = repository.findAll();
        for (Details client : clients) {
            clientsList.add(client);
        }
        return clientsList;
    }

    @Override
    public Details update(Details entity)
    {
        return repository.save(entity);
    }

    @Override
    public Details readById(Long id)
    {
        return repository.findOne(id);
    }

    @Override
    public void delete(Details entity) {
        repository.delete(entity);

    }

}
