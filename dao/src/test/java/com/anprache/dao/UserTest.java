package com.anprache.dao;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class UserTest extends BaseDaoTest {
    @Test
    public void testUserAccountCreation() throws Exception {
        User user = new User();
        user.setName("First Second Name");
        user.setAccountId("ACC1");
        boolean success = user.saveIt();
        Assert.assertTrue(success);
    }

    @Test
    public void testUserAccountSearch() throws Exception {
        User userAccount = new User();
        userAccount.setAccountId("ACC1");
        userAccount.setName("First Second Name");
        boolean success = userAccount.saveIt();
        Assert.assertTrue(success);
        List<User> users = User.findBySQL("SELECT * FROM users WHERE account_id like 'ACC%'");
        Assert.assertTrue(users.size() >= 1);

    }
}
