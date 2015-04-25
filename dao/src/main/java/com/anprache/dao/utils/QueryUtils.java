package com.anprache.dao.utils;

import com.anprache.dao.Follow;
import com.anprache.dao.LikeDislike;
import com.anprache.dao.User;
import com.anprache.social.common.utils.CompareUtils;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class QueryUtils {
    public static LinkedHashSet<Integer> getLikedProducts(String accountId) {
        List<LikeDislike> following = LikeDislike.where(LikeDislike.ACCOUNT_ID + " = ?", accountId);
        List<Integer> products = following.stream().map(LikeDislike::getProductId).collect(Collectors.toList());
        return new LinkedHashSet<>(products);
    }

    public static List<Follow> getFollowingPeople(String accountId) {
        List<Follow> following = Follow.where(Follow.FOLLOWED_BY + " = ?", accountId);
        return following;
    }

    public static User getUser(String accountId) {
        return User.findFirst(User.ACCOUNT_ID + " = ?", accountId);
    }

    public static double getCompareResult(String originAccountId, String comparatorAccountId) {
        LinkedHashSet originProducts = getLikedProducts(originAccountId);
        LinkedHashSet comparatorProducts = getLikedProducts(comparatorAccountId);
        return CompareUtils.compare(originProducts, comparatorProducts);
    }
    public static List<User> getUsers(String namePrefix) {
        return User.findBySQL("SELECT * FROM users WHERE name like '" + namePrefix + "%'");
    }
}
