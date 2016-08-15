package net.ru.sbt.group;

import net.ru.sbt.account.Account;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int countAccount;
    private List<Account> accounts;
    private String name;


    public Group(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        accounts = new ArrayList<>();
        this.name = name;
    }

    public void addAccount(Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        if (accounts.contains(account)) {
            return;
        }
        accounts.add(account);
        countAccount = accounts.size();
    }

    public int getCountAccount() {
        return countAccount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public String getName() {
        return name;
    }
}
