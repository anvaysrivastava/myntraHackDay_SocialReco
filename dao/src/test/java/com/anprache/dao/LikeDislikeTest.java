package com.anprache.dao;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class LikeDislikeTest extends BaseDaoTest {

    @Test
    public void testLikeIntegration() throws Exception {
        LikeDislike likeDislike = new LikeDislike();
        likeDislike.setAccountId("ACC1");
        likeDislike.setProductId(123);
        boolean success = likeDislike.saveIt();
        Assert.assertTrue(success);

    }

    @Test
    public void testSelectLike() throws Exception {
        for (int i = 0; i < 10; i++) {
            LikeDislike likeDislike = new LikeDislike();
            likeDislike.setAccountId("ACC" + i % 3);
            likeDislike.setProductId(i);
            likeDislike.saveIt();
        }
        List<LikeDislike> acc1LikeDislike = LikeDislike.where(LikeDislike.ACCOUNT_ID + " = ?", "ACC0");
        Assert.assertEquals(acc1LikeDislike.size(), 4);
        List<LikeDislike> acc2LikeDislike = LikeDislike.where(LikeDislike.ACCOUNT_ID + " = ?", "ACC1");
        Assert.assertEquals(acc2LikeDislike.size(), 3);
        List<LikeDislike> acc3LikeDislike = LikeDislike.where(LikeDislike.ACCOUNT_ID + " = ?", "ACC2");
        Assert.assertEquals(acc3LikeDislike.size(), 3);
    }
}
