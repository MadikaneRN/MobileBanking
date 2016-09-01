package za.ac.cput.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.domain.Details;
import za.ac.cput.services.DetailsService;

import java.util.List;

/**
 * Created by Scorpian on 2016-09-01.
 */

@RestController
public class DetailsController {

    @Autowired
    private DetailsService detailService;

    //--------------------------------------Create Client------------------------------------
    @RequestMapping(value = "/detail/create", method = RequestMethod.PUT)
    public ResponseEntity<Void> createDetails(@RequestBody Details detail, UriComponentsBuilder ucBuilder)
    {
        detailService.create(detail);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/detail/{id}").buildAndExpand(detail.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //-------------------Retrieve Single Story--------------------------------------------------------
    @RequestMapping(value = "/detail/read/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Details> getDetails(@PathVariable("id") long id) {
       Details detail = detailService.readById(id);
        if (detail == null) {
            return new ResponseEntity<Details>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Details>(detail, HttpStatus.OK);
    }



    //---------------------Retrieve List of Clients---------------------------------------------------
    @RequestMapping(value = "/details/",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Details>> getAllDetails()
    {
        List<Details> clients = detailService.readAll();
        if(clients.isEmpty())
        {
            return new ResponseEntity<List<Details>>(HttpStatus.NO_CONTENT);//OR HttpStatus.Not_Found
        }

        return new ResponseEntity<List<Details>>(clients,HttpStatus.OK);
    }


    //-------------------------------------------Delete---------------------------------------------------

    @RequestMapping(value = "/details/delete/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Details> deleteDetails(@PathVariable("id")long id)
    {
        System.out.println("Fetching & Deleting Patient with id" + id);

        Details client = detailService.readById(id);
        if(client == null)
        {
            System.out.println("Unable to delete. Patient with id " + id + " not found");//comment
            return new ResponseEntity<Details>(HttpStatus.NOT_FOUND);

        }

        detailService.delete(client);
        return new ResponseEntity<Details>(HttpStatus.NO_CONTENT);
    }

    //----------------------------------Update----------------------------------------------------
    @RequestMapping(value = "/details/update/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Details> updateDetails(@PathVariable("id") long id, @RequestBody Details client)
    {
        System.out.println("Updating Client " + id);

        Details currentClient = detailService.readById(id);

        if(currentClient == null)
        {
            System.out.println("Client with id" +id+ "not found");
            return new ResponseEntity<Details>(HttpStatus.NOT_FOUND);
        }

        Details updatedClient = new Details.Builder().copy(currentClient)
                .city(client.getCity())
                .streetName(client.getStreetName())
                .postalCode(client.getPostalCode())
                .build();
        detailService.update(updatedClient);

        return new ResponseEntity<Details>(updatedClient,HttpStatus.OK);
    }




}
