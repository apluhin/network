package net.ru.sbt.account;

import java.util.List;
import java.util.stream.Collectors;

public class FriendImpl implements Friend {

    Auth auth;

    public FriendImpl(Auth auth) {
        this.auth = auth;
    }

    @Override
    public void addFriend(Account account, String name) {
        account.addFriend(auth.getAccount(name));
    }

    @Override
    public void deleteFriend(Account account, String name) {
        account.deleteFriend(auth.getAccount(name));
    }

    @Override
    public List<String> checkFriends(Account account) {
        return account.getFriend().stream().map(Account::getName).collect(Collectors.toList());
    }
}
