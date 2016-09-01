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
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String accNo;
    private double balance;
    private String accountType;

    private Account()
    {
    }

    public Account(Builder builder) {
        this.id = builder.id;
        this.accNo = builder.accNo;
        this.balance = builder.balance;
        this.accountType = builder.accountType;

    }


    public long getId()
    {
        return id;
    }
    public String getAccNo() {
        return accNo;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }


    public static class Builder {

        private long id;
        private String accNo;
        private double balance;
        private String accountType;


        public Builder accNo(String accNo) {
            this.accNo = accNo; //compalsury
            return this;
        }

        public Builder id(long value) {
            this.id = value;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder accountType(String value)
        {
            this.accountType = value;
            return this;
        }

        public Builder copy(Account account)
        {
            this.id = account.id;
            this.accountType = account.accountType;
            this.balance = account.balance;
            this.accNo = account.accNo;
            return this;
        }




        public Account build()
        {
            return new Account(this);
        }

    }

}

