package com.anprache.dao.utils;

import com.anprache.dao.Follow;
import com.anprache.dao.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class QueryUtils {
    public static List<String> getFollowingProduct(String accountId) {
        List<Follow> following = Follow.where(Follow.FOLLOWED_BY + " = ?", accountId);
        return following.stream().map(Follow::getFollows).collect(Collectors.toList());
    }

    public static List<Follow> getFollowing(String accountId) {
        List<Follow> following = Follow.where(Follow.FOLLOWED_BY + " = ?", accountId);
        return following;
    }

    public static User getUser(String accountId) {
        return User.findFirst(User.ACCOUNT_ID + " = ?", accountId);
    }
}
