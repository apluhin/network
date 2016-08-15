package net.ru.sbt.group;


import net.ru.sbt.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupStoreImplTest {

    GroupStore groupStore;
    String name1 = "group1";
    String name2 = "group2";

    @Before
    public void setUp() throws Exception {
        groupStore = new GroupStoreImpl();
    }

    @Test
    public void testAddGroup() throws Exception {

        groupStore.addGroup(name1);
        groupStore.addGroup(name1);
        assertEquals(groupStore.getCountGroup(), 1);
        groupStore.addGroup(name2);
        assertEquals(groupStore.getCountGroup(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAddGroup() {
        groupStore.addGroup(null);
    }

    @Test
    public void testFindGroupByName() {
        groupStore.addGroup(name1);
        assertEquals(groupStore.findGroup(name1).getName(), name1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullAccount() {
        groupStore.addGroup(name1);
        groupStore.addToGroup(name1, null);
    }

    @Test
    public void testAddAccount() throws Exception {
        groupStore.addGroup(name1);
        Account account = new Account("name", "tets");
        Account account1 = new Account("name1", "tets1");
        groupStore.addToGroup(name1, account);
        groupStore.addToGroup(name1, account1);
        assertEquals(groupStore.findGroup(name1).getCountAccount(), 2);

    }
}