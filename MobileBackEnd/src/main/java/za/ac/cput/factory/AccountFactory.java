package za.ac.cput.factory;

import za.ac.cput.domain.Account;

import java.io.Serializable;

/**
 * Created by Scorpian on 2016-09-01.
 */
public class AccountFactory implements Serializable {
    public static Account getAccount(String accNo, double balance, String accountType)
    {
        Account myAccount = new Account.Builder()
                .accNo(accNo)
                .balance(balance)
                .accountType(accountType)
                .build();
        return myAccount;
    }

}
