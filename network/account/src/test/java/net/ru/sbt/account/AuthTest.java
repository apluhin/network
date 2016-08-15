package net.ru.sbt.account;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthTest {

    Auth auth;
    String id = "a";
    String pass = "b";


    @Before
    public void setUp() {
        auth = new Auth();

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSignInWithWrongPass() {
        auth.signUp(id, pass + "a");
        auth.signIn(id, pass);
    }

    @Test(expected = RuntimeException.class)
    public void testSignUpInCreatedAccount() {
        auth.signUp(id, pass);
        auth.signUp(id, pass);
    }

    @Test
    public void testSignInWithRightPass() {
        auth.signUp(id, pass);
        Account account = auth.signIn(id, pass);
        Assert.assertEquals(account.getName(), id);
        Assert.assertEquals(account.getPassword(), pass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullIdSignIn() {
        auth.signIn(null, pass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassSignIp() {
        auth.signIn(pass, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullIdSignUp() {
        auth.signUp(null, pass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullPassSignUp() {
        auth.signUp(pass, null);
    }

    @Test
    public void testCheckBooleanIn() {
        auth.signUp(id, pass);
        Account account = auth.signIn(id, pass);
        Assert.assertEquals(account.isIn(), true);
    }


}