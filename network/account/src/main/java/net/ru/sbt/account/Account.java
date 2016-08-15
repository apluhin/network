package net.ru.sbt.account;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private String password;
    private boolean isIn = false;
    protected List<Account> friend = new ArrayList<>();

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        online();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIn() {

        return isIn;
    }

    public void online() {
        isIn = !isIn;
    }

    List<Account> getFriend() {
        return friend;
    }

    public void addFriend(Account account) {
        friend.add(account);
        account.getFriend().add(this);
    }

    public void deleteFriend(Account account) {
        friend.remove(account);
        account.getFriend().remove(this);
    }

}
