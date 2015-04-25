package com.anprache.dao;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class LoginTest extends BaseDaoTest {

    @Test
    public void testLoginIntegration() throws Exception {
        Login login = new Login();
        login.setEmail("testEmail@test.com");
        login.setPassword("randomPassword");
        boolean success = login.saveIt();
        Assert.assertTrue(success);
        Login loginFind = Login.findFirst(Login.EMAIL + " = ?", "testEmail@test.com");
        Assert.assertEquals(loginFind.getPassword(), "randomPassword");
    }

}
