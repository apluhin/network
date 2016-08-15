package net.ru.sbt.server;

import net.ru.sbt.account.Account;
import net.ru.sbt.group.Group;
import net.ru.sbt.message.Message;

import java.util.List;

public interface Server {

    void sendMessage(Message message);

    List<Message> checkMessage(Account current);

    Account signIn(String id, String pass);

    Account signUp(String id, String pass);

    void addFriend(Account account, String name);

    void deleteFriend(Account account, String name);

    List<String> checkFriends(Account account);

    void signOut(Account account);

    Group findGroup(String name);

    void addToGroup(String name, Account account);

    void addGroup(String name);


}
