package net.ru.sbt.group;

import net.ru.sbt.account.Account;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {

    Group group = new Group("group1");

    @Test
    public void testAddInGroup() {
        Account account1 = new Account("1", "1");
        Account account2 = new Account("1", "1");


        group.addAccount(account1);
        Assert.assertEquals(group.getCountAccount(), 1);
        group.addAccount(account2);
        Assert.assertEquals(group.getCountAccount(), 2);
        group.addAccount(account2);
        Assert.assertEquals(group.getCountAccount(), 2);
    }

    @Test
    public void testCorrectField() {
        Group group = new Group("test");
        assertEquals(group.getName(), "test");
        assertEquals(group.getCountAccount(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParametr() throws Exception {
        Group group = new Group(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPutNullAccount() throws Exception {
        group.addAccount(null);
    }
}