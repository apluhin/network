package net.ru.sbt.server;


import net.ru.sbt.account.Account;
import net.ru.sbt.account.Auth;
import net.ru.sbt.account.Friend;
import net.ru.sbt.account.FriendImpl;
import net.ru.sbt.group.Group;
import net.ru.sbt.group.GroupStore;
import net.ru.sbt.group.GroupStoreImpl;
import net.ru.sbt.message.Message;
import net.ru.sbt.message.MessageStore;

import java.util.List;

public class ServerImpl implements Server {

    Auth auth;
    MessageStore messageStore;
    Friend friend;
    GroupStore group;


    public ServerImpl(Auth auth, MessageStore messageStore) {
        this.auth = auth;
        this.messageStore = messageStore;
        friend = new FriendImpl(auth);
        group = new GroupStoreImpl();
    }

    @Override
    public void sendMessage(Message message) {
        messageStore.sendMessage(message);
    }

    @Override
    public List<Message> checkMessage(Account current) {
        return messageStore.checkMessage(current);
    }

    @Override
    public Account signIn(String id, String pass) {
        return auth.signIn(id, pass);
    }

    @Override
    public Account signUp(String id, String pass) {
        return auth.signUp(id, pass);
    }


    @Override
    public void addFriend(Account account, String name) {
        friend.addFriend(account, name);
    }

    @Override
    public void deleteFriend(Account account, String name) {
        friend.deleteFriend(account, name);
    }

    @Override
    public void signOut(Account account) {
        auth.signOut(account);
    }

    @Override
    public Group findGroup(String name) {
        return group.findGroup(name);
    }

    @Override
    public void addToGroup(String name, Account account) {
        group.addToGroup(name, account);
    }

    @Override
    public void addGroup(String name) {
        group.addGroup(name);
    }

    @Override
    public List<String> checkFriends(Account account) {
        return friend.checkFriends(account);
    }


}
