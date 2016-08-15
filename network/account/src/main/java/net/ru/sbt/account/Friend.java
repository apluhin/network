package net.ru.sbt.account;

import java.util.List;

public interface Friend {

    void addFriend(Account account, String name);

    void deleteFriend(Account account, String name);

    List<String> checkFriends(Account account);
}
