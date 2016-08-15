package net.ru.sbt.group;

import net.ru.sbt.account.Account;

public interface GroupStore {

    Group findGroup(String name);

    void addToGroup(String name, Account account);

    void addGroup(String name);

    int getCountGroup();

}
