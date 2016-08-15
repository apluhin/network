package net.ru.sbt.account;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Test
    public void testDeleteAndAddFriend() {
        Account account1 = new Account("1", "pass");
        Account account2 = new Account("2", "pass");
        account1.addFriend(account2);
        Assert.assertEquals(account1.getFriend().contains(account2), true);
        Assert.assertEquals(account2.getFriend().contains(account1), true);
        account1.deleteFriend(account2);
        Assert.assertEquals(account1.getFriend().contains(account2), false);
        Assert.assertEquals(account2.getFriend().contains(account1), false);
    }


}