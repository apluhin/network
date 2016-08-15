package net.ru.sbt.account;

import java.util.HashMap;
import java.util.Map;


public class Auth {

    Map<String, Account> accountMap = new HashMap<>();


    public Account signIn(String id, String pass) {
        if (id == null || pass == null || id.length() == 0 || pass.length() == 0) {
            throw new IllegalArgumentException();
        }
        Account account = accountMap.get(id);
        if (account == null) {
            throw new RuntimeException("Unregister account");
        }
        if (!account.getPassword().equals(pass)) {
            throw new IllegalArgumentException("Wrong password");
        } else {
            if (!account.isIn()) {
                account.online();
            }
            return account;
        }
    }


    public Account signUp(String id, String pass) {
        if (id == null || pass == null) {
            throw new IllegalArgumentException("Null field");
        }
        if (accountMap.containsKey(id)) {
            throw new RuntimeException("User registered yet");
        } else {
            accountMap.put(id, new Account(id, pass));
            return accountMap.get(id);
        }
    }


    public void signOut(Account account) {
        accountMap.get(account.getName()).online();
    }

    public Account getAccount(String id) {
        return accountMap.get(id);
    }

}
