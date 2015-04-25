package com.anprache.dao;

import org.javalite.activejdbc.Model;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class LikeDislike extends Model {
    public static String ID = "id";
    public static String ACCOUNT_ID = "account_id";
    public static String PRODUCT_ID = "product_id";

    public String getAccountId() {
        return (String) get(ACCOUNT_ID);
    }

    public void setAccountId(String accountId) {
        set(ACCOUNT_ID, accountId);
    }

    public int getProductId() {
        return getInteger(PRODUCT_ID);
    }

    public void setProductId(int productId) {
        set(PRODUCT_ID, productId);
    }
}
