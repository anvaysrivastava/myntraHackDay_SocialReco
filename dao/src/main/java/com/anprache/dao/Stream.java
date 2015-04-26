package com.anprache.dao;

import org.javalite.activejdbc.Model;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class Stream extends Model {
    public static String PRODUCT_ID = "product_id";
    public static String FOR_ACCOUNT_ID = "for_account_id";
    public static String FROM_ACCOUNT_ID = "from_account_id";

    public String getForAccountId(){ return (String) get(FOR_ACCOUNT_ID); }
    public void setForAccountId(String forAccountId){ set(FOR_ACCOUNT_ID,forAccountId); }

    public String getFromAccountId(){ return (String) get(FROM_ACCOUNT_ID); }
    public void setFromAccountId(String fromAccountId){ set(FROM_ACCOUNT_ID,fromAccountId); }

    public int getProductId() {
        return getInteger(PRODUCT_ID);
    }

    public void setProductId(int productId) {
        set(PRODUCT_ID, productId);
    }

}
