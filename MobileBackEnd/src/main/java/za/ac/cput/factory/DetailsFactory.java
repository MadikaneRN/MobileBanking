package za.ac.cput.factory;

import za.ac.cput.domain.Details;

/**
 * Created by Scorpian on 2016-09-01.
 */


public class DetailsFactory {

    public static Details getDetails(String streetName, String city, String postalCode)
    {
        Details myAdress = new Details.Builder() // change name to conivinient name
                .streetName(streetName)
                .city(city)
                .postalCode(postalCode)
                .build();

        return myAdress;
    }

}
