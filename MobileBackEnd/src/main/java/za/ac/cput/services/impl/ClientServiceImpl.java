package za.ac.cput.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.repository.ClientRepository;
import za.ac.cput.services.ClientService;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Scorpian on 2016-08-08.
 */

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public Client create(Client entity)
    {
        return repository.save(entity);
    }

    @Override
    public List<Client> readAll()
    {
        List<Client> clientsList = new ArrayList<Client>();
        Iterable<Client> clients = repository.findAll();
        for (Client client : clients) {
            clientsList.add(client);
        }
        return clientsList;
    }

    @Override
    public Client update(Client entity)
    {
        return repository.save(entity);
    }

    @Override
    public Client readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Client entity) {
        repository.delete(entity);

    }

}
