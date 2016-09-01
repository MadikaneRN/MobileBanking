package za.ac.cput.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Scorpian on 2016-09-01.
 */

@Entity
public class Details implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String streetName;
    private String city;
    private String postalCode;


    private Details()
    {

    }

    public Details(Builder builder) {

        this.id = builder.id;
        this.streetName = builder.streetName;
        this.city = builder.city;
        this.postalCode = builder.postalCode;

    }


    public Long getId()
    {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }


    public static class Builder {

        //Equivalent to setters
        private long id;
        private String streetName;
        private String city;
        private String postalCode;


        public Builder id(long value){
            this.id =value;
            return this;
        }


        public Builder streetName(String streetName)
        {
            this.streetName = streetName; //compalsury
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }




        public Builder copy(Details address){
            this.id = address.id;
            this.streetName =address.streetName;
            this.city = address.city;
            this.postalCode =address.postalCode;
            return this;
        }




        public Details build() {
            return new Details(this);
        }
    }

}
