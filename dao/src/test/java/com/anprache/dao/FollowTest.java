package com.anprache.dao;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class FollowTest extends BaseDaoTest {
    @Test
    public void testAddFollows() throws Exception {

        Follow follow = new Follow();
        follow.setFollowedBy("ACC1");
        follow.setFollows("ACC2");
        boolean success = follow.saveIt();
        Assert.assertTrue(success);

    }

    @Test
    public void testGetFollowers() throws Exception {
        Follow follow = new Follow();
        follow.setFollowedBy("ACC1");
        follow.setFollows("ACC2");
        follow.saveIt();

        List<Follow> followList = Follow.where(Follow.FOLLOWED_BY + " = ?", "ACC1");
        Assert.assertTrue(followList.size() >= 1);

    }
}
