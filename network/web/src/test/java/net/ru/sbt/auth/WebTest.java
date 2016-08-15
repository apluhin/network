package net.ru.sbt.auth;

import net.ru.sbt.server.Server;
import net.ru.sbt.server.ServerImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class WebTest {

    @Mock
    Server server;

    String id = "id";
    String pass = "pass";

    @Before
    public void setUp() throws Exception {
        server = Mockito.mock(ServerImpl.class);

    }

    @Test
    public void testDeligateSignIn() throws Exception {
        server.signIn(id, pass);
        Mockito.verify(server).signIn(id, pass);
    }

    @Test
    public void testDeligateSignUp() throws Exception {
        server.signUp(id, pass);
        Mockito.verify(server).signUp(id, pass);
    }

    @Test(expected = Exception.class)
    public void testDeligateFriend() throws NoSuchFieldException {
        Mockito.when(server.getClass().getField("friend")).thenThrow(Exception.class);
        server.addFriend(null, null);
        server.checkFriends(null);
        server.deleteFriend(null, null);

    }
}