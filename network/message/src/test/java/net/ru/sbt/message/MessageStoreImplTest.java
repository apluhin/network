package net.ru.sbt.message;

import net.ru.sbt.account.Account;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MessageStoreImplTest {

    MessageStore messageStore;


    @Before
    public void setUp() {
        messageStore = new MessageStoreImpl();

    }

    @Test
    public void testStoreMessageContains() {
        Message message = new Message("alex", "pavel", "Hi");
        Account account = new Account("alex", "pass");
        Account account1 = new Account("pavel", "pass");
        messageStore.sendMessage(message);
        Assert.assertEquals(messageStore.checkMessage(account1).contains(message), true);
        Assert.assertEquals(messageStore.checkMessage(account).contains(message), true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptySrc() {
        Message message = new Message("", "pavel", "a");
        messageStore.sendMessage(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyDst() {
        Message message = new Message("alex", "", "a");
        messageStore.sendMessage(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyMess() {
        Message message = new Message("alex", "pavel", "");
        messageStore.sendMessage(message);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAccount() {
        messageStore.checkMessage(null);
    }

    @Test
    public void testSomeMessage() {
        Message message = new Message("alex", "pavel", "a");
        Message message1 = new Message("alex", "pavel", "a");
        Account account = new Account("alex", "pass");
        Account account1 = new Account("pavel", "pass");
        int size = messageStore.checkMessage(account).size();
        messageStore.sendMessage(message);
        messageStore.sendMessage(message1);
        Assert.assertEquals(messageStore.checkMessage(account).size() - 2, size);
        Assert.assertEquals(messageStore.checkMessage(account1).size() - 2, size);
    }


}