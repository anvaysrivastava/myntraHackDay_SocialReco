package com.anprache.dao.utils;

import com.anprache.dao.BaseDaoTest;
import com.anprache.dao.Follow;
import com.anprache.dao.LikeDislike;
import com.anprache.dao.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class QueryUtilsTest extends BaseDaoTest {
    @Test
    public void testGetFollowingProduct() throws Exception {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC1");
        likeDislike.setProductId(1);
        likeDislike.saveIt();

        likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC1");
        likeDislike.setProductId(2);
        likeDislike.saveIt();

        likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC2");
        likeDislike.setProductId(2);
        likeDislike.saveIt();

        likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC1");
        likeDislike.setProductId(3);
        likeDislike.saveIt();

        likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC1");
        likeDislike.setProductId(4);
        likeDislike.saveIt();

        List<Integer> productFollowed = QueryUtils.getLikedProducts("ACC1");
        Assert.assertEquals(productFollowed.size(), 4);
        Assert.assertEquals(productFollowed.stream().map(String::valueOf).collect(Collectors.toList()).size(), 4);
    }

    @Test
    public void testGetFollowing() throws Exception {
        Follow follow = new Follow();
        follow.setFollowedBy("ACC1");
        follow.setFollows("ACC2");
        follow.saveIt();

        follow = new Follow();
        follow.setFollowedBy("ACC1");
        follow.setFollows("ACC3");
        follow.saveIt();

        follow = new Follow();
        follow.setFollowedBy("ACC2");
        follow.setFollows("ACC1");
        follow.saveIt();

        follow = new Follow();
        follow.setFollowedBy("ACC3");
        follow.setFollows("ACCX");
        follow.saveIt();

        List<Follow> productFollowed = QueryUtils.getFollowingPeople("ACC1");
        Assert.assertEquals(productFollowed.size(), 2);
    }

    @Test
    public void testGetUser() throws Exception {
        User user = new User();
        user.setAccountId("ACC1");
        user.setName("Name #1");
        user.saveIt();

        user = new User();
        user.setAccountId("ACC2");
        user.setName("Name #2");
        user.saveIt();

        User user1 = QueryUtils.getUser("ACC1");
        Assert.assertEquals(user1.getName(), "Name #1");
    }
}
