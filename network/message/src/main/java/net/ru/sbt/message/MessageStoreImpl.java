package net.ru.sbt.message;

import net.ru.sbt.account.Account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStoreImpl implements MessageStore {

    protected static Map<String, List<Message>> STORAGE = new HashMap<>();


    @Override
    public void sendMessage(Message message) {

        if (message == null || message.getMessage().length() == 0 || message.getIdDest().length() == 0
                || message.getIdFrom().length() == 0) {
            throw new IllegalArgumentException();
        }

        List<Message> messagesDest = STORAGE.getOrDefault(message.getIdDest(), new ArrayList<>());
        List<Message> messagesSrc = STORAGE.getOrDefault(message.getIdFrom(), new ArrayList<>());
        messagesDest.add(message);
        messagesSrc.add(message);
        STORAGE.put(message.getIdFrom(), messagesSrc);
        STORAGE.put(message.getIdDest(), messagesDest);

    }

    @Override
    public List<Message> checkMessage(Account account) {
        if (account == null) {
            throw new IllegalArgumentException();
        }
        return STORAGE.get(account.getName());
    }


}
