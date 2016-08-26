package za.ac.cput.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Scorpian on 2016-08-09.
 */


@RestController
public class HelloWorld {
    @Autowired

    @RequestMapping("/hello")
    public String getValue()
    {
        return "Hi There im from Tomcat server";
    }

}
