package za.ac.cput.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.domain.Account;
import za.ac.cput.services.AccountService;

import java.util.List;

/**
 * Created by Scorpian on 2016-09-01.
 */

@RestController
public class AccountController {
    @Autowired
    private AccountService clientService;

    //--------------------------------------Create Client------------------------------------
    @RequestMapping(value = "/account/create", method = RequestMethod.PUT)
    public ResponseEntity<Void> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder)
    {
        clientService.create(account);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/account/{id}").buildAndExpand(account.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/account/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
        Account client = clientService.readById(id);
        if (client == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Account>(client, HttpStatus.OK);
    }

    //---------------------Retrieve List of Clients---------------------------------------------------
    @RequestMapping(value = "/accounts/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAllAccounts()
    {
        List<Account> clients =clientService.readAll();
        if(clients.isEmpty())
        {
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }

        return new ResponseEntity<List<Account>>(clients,HttpStatus.OK);
    }

    //-------------------------------------------Delete---------------------------------------------------


    @RequestMapping(value = "/account/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id")long id)
    {
        System.out.println("Fetching & Deleting Patient with id" + id);

        Account client = clientService.readById(id);
        if(client == null)
        {
            System.out.println("Unable to delete. Patient with id " + id + " not found");//comment
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);

        }

        clientService.delete(client);
        return new ResponseEntity<Account>(HttpStatus.NO_CONTENT);
    }


    //----------------------------------Update----------------------------------------------------
    @RequestMapping(value = "/account/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account client)
    {
        System.out.println("Updating Accountt " + id);

        Account currentClient = clientService.readById(id);

        if(currentClient == null)
        {
            System.out.println("Account with id" +id+ "not found");
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }

        Account updatedClient = new Account.Builder().copy(currentClient)
                .accNo(client.getAccNo())
                .accountType(client.getAccountType())
                .balance(client.getBalance())
                .build();
        clientService.update(updatedClient);

        return new ResponseEntity<Account>(updatedClient,HttpStatus.OK);
    }




}
