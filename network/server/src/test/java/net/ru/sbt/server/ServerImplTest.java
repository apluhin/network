package net.ru.sbt.server;

import net.ru.sbt.account.Account;
import net.ru.sbt.account.Auth;
import net.ru.sbt.message.Message;
import net.ru.sbt.message.MessageStore;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class ServerImplTest {


    Server server;

    @Mock
    Auth auth;


    @Mock
    MessageStore messageStore;


    String id = "a";
    String pass = "b";
    Account account = new Account("name", "pass");


    @Before
    public void setUp() {
        auth = Mockito.mock(Auth.class);
        messageStore = Mockito.mock(MessageStore.class);

        server = new ServerImpl(auth, messageStore);
    }


    @Test
    public void testDeligate() {
        server.signUp(id, pass);
        server.signIn(id, pass);
        Account account = new Account(id, pass);
        server.signOut(account);
        server.checkMessage(account);

        Message message = new Message("id", "id", "mess");
        server.sendMessage(message);

        Mockito.verify(auth).signUp(id, pass);
        Mockito.verify(auth).signIn(id, pass);
        Mockito.verify(auth).signOut(account);
        Mockito.verify(messageStore).checkMessage(account);
        Mockito.verify(messageStore).sendMessage(message);

    }


}