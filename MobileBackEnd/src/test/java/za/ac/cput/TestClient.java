package za.ac.cput;

import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.repository.ClientRepository;

/**
 * Created by Scorpian on 2016-08-09.
 */

@SpringApplicationConfiguration(classes =App.class)
@WebAppConfiguration

public class TestClient  extends AbstractTestNGSpringContextTests{

    private long id;

    @Autowired
    ClientRepository myrepo;

    @Test
    public void create() throws Exception
    {
        Client myClient = ClientFactory.getClient("883328455","Jomo","Sono");
        myrepo.save(myClient);
    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception
    {

    }



}
