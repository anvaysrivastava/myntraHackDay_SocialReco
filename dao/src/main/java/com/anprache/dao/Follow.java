package com.anprache.dao;

import org.javalite.activejdbc.Model;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class Follow extends Model {
    public static String FOLLOWED_BY = "followed_by";
    public static String FOLLOWS = "follows";

    public String getFollowedBy() {
        return getString(FOLLOWED_BY);
    }

    public void setFollowedBy(String followedBy) {
        setString(FOLLOWED_BY, followedBy);
    }

    public String getFollows() {
        return getString(FOLLOWED_BY);
    }

    public void setFollows(String follows) {
        setString(FOLLOWS, follows);
    }

}
