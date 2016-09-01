package za.ac.cput.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.domain.Client;
import za.ac.cput.services.ClientService;
import java.util.List;
/**
 * Created by Scorpian on 2016-08-09.
 */
@RestController
public class ClientController {

    // Inject Service
    @Autowired
    private ClientService clientService;

    //--------------------------------------Create Client------------------------------------
    @RequestMapping(value = "/client/create", method = RequestMethod.PUT)
    public ResponseEntity<Void> createClient(@RequestBody Client client, UriComponentsBuilder ucBuilder)
    {
        clientService.create(client);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/client/{id}").buildAndExpand(client.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/client/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") long id) {
        Client client = clientService.readById(id);
        if (client == null) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Client>(client, HttpStatus.OK);
    }

    //---------------------Retrieve List of Clients---------------------------------------------------
    @RequestMapping(value = "/clients/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getAllClients()
    {
        List<Client> clients =clientService.readAll();
        if(clients.isEmpty())
        {
            return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }

        return new ResponseEntity<List<Client>>(clients,HttpStatus.OK);
    }

    //-------------------------------------------Delete---------------------------------------------------

    @RequestMapping(value = "/client/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Client> deleteClient(@PathVariable("id")long id)
    {
        System.out.println("Fetching & Deleting Patient with id" + id);

        Client client = clientService.readById(id);
        if(client == null)
        {
            System.out.println("Unable to delete. Patient with id " + id + " not found");//comment
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);

        }

        clientService.delete(client);
        return new ResponseEntity<Client>(HttpStatus.NO_CONTENT);
    }

    //----------------------------------Update----------------------------------------------------
    @RequestMapping(value = "/client/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client)
    {
        System.out.println("Updating Client " + id);

        Client currentClient = clientService.readById(id);

        if(currentClient == null)
        {
            System.out.println("Client with id" +id+ "not found");
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }

        Client updatedClient = new Client.Builder().copy(currentClient)
                .idNo(client.getIdNo())
                .surName(client.getSurName())
                .name(client.getName())
                .build();
        clientService.update(updatedClient);

        return new ResponseEntity<Client>(updatedClient,HttpStatus.OK);
    }


}




