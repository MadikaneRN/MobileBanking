
package za.ac.cput.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Scorpian on 2016-03-28.
 */

@Entity
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String idNo;
    private String name;
    private String surName;

    private Client(){}
    public Client(Builder builder) {

        this.id = builder.id;
        this.idNo = builder.idNo;
        this.surName = builder.surName;
        this.name = builder.name;
    }


    public long getId()
    {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getIdNo() {
        return idNo;
    }


    public static class Builder {

        //Equivalent to setters
        private long id;
        private String name;
        private String surName;
        private String idNo;


        public Builder id(long value)
        {
            this.id = value;
            return this;
        }

        public Builder idNo (String idNo) {
            this.idNo = idNo;
            return this;
        }




        public Builder surName(String Surname) {
            this.surName = Surname;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }



        public Builder copy(Client client){
            this.id = client.id;
            this.idNo = client.idNo;
            this.name = client.name;
            this.surName = client.surName;
            return this;
        }



        public Client build() {
            return new Client(this);
        }
    }

    /*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return id == client.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
    */

    /*
    public String toString()
    {
        return String.format("Id : %d\nName :%s\nSurname :%s\nIdNum :%s",id,name,surName,idNo);
    }
    */

}
