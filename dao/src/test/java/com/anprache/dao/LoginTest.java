package com.anprache.dao;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class LoginTest {
    @Before
    public void setUp() throws Exception {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/myntra", "root", "");
        Base.openTransaction();
    }

    @After
    public void tearDown() throws Exception {
        Base.rollbackTransaction();
        Base.close();

    }

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
