package com.anprache.dao;

import org.javalite.activejdbc.Model;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class User extends Model {
    public static String ACCOUNT_ID = "account_id";
    public static String NAME = "name";
    public static String IMAGE = "image";

    public String getAccountId() {
        return (String) get(ACCOUNT_ID);
    }

    public void setAccountId(String accountId) {
        set(ACCOUNT_ID, accountId);
    }

    public String getImage() {
        return (String) get(IMAGE);
    }

    public void setImage(String image) {
        set(IMAGE, image);
    }

    public String getName() {
        return (String) get(NAME);
    }

    public void setName(String name) {
        set(NAME, name);
    }

}
