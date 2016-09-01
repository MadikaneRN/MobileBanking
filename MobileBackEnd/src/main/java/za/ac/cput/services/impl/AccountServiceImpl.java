package za.ac.cput.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Account;
import za.ac.cput.repository.AccountRepository;
import za.ac.cput.services.AccountService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scorpian on 2016-09-01.
 */

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository repository;

    @Override
    public Account create(Account entity)
    {
        return repository.save(entity);
    }

    @Override
    public List<Account> readAll()
    {
        List<Account> clientsList = new ArrayList<Account>();
        Iterable<Account> clients = repository.findAll();
        for (Account client : clients) {
            clientsList.add(client);
        }
        return clientsList;
    }

    @Override
    public Account update(Account entity)
    {
        return repository.save(entity);
    }

    @Override
    public Account readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Account entity) {
        repository.delete(entity);

    }



}
