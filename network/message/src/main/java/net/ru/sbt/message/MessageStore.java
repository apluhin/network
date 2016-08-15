package net.ru.sbt.message;

import net.ru.sbt.account.Account;

import java.util.List;

public interface MessageStore {

    void sendMessage(Message message);

    List<Message> checkMessage(Account account);


}
