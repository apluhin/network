package net.ru.sbt.account;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class FriendImplTest {
    @Mock
    Auth auth;
    Friend friend;
    Account account = Mockito.mock(new Account("name", "pass").getClass());
    Account account1 = Mockito.mock(new Account("name1", "pass1").getClass());

    @Before
    public void setUp() throws Exception {
        auth = Mockito.mock(Auth.class);
        friend = new FriendImpl(auth);

    }

    @Test
    public void testDeligateCheck() {
        Mockito.when(friend.checkFriends(account)).thenReturn(new ArrayList<>());
        friend.checkFriends(account);
        Mockito.verify(account).getFriend();

    }

    @Test(expected = Exception.class)
    public void testDeligateAdd() {
        Mockito.doThrow(new Exception()).when(friend).addFriend(account, account1.getName());
        friend.addFriend(account, account1.getName());
    }

    @Test(expected = Exception.class)
    public void testDeligateDelete() {
        Mockito.doThrow(new Exception()).when(friend).deleteFriend(account, account1.getName());
        friend.deleteFriend(account, account1.getName());
    }


}