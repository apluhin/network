package net.ru.sbt.group;


import net.ru.sbt.account.Account;

import java.util.HashMap;
import java.util.Map;

public class GroupStoreImpl implements GroupStore {

    Map<String, Group> groupMap = new HashMap<>();


    @Override
    public Group findGroup(String name) {
        return groupMap.get(name);
    }

    @Override
    public void addToGroup(String name, Account account) {
        groupMap.get(name).addAccount(account);
    }

    @Override
    public void addGroup(String name) {
        if (!groupMap.containsKey(name)) {
            groupMap.put(name, new Group(name));
        }
    }

    @Override
    public int getCountGroup() {
        return groupMap.size();
    }
}
