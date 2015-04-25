package com.anprache.dao.utils;

import com.anprache.Constants;
import org.javalite.activejdbc.Base;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class DBUtils {
    public static void init() {
        Base.open(Constants.JDBC_DRIVER, Constants.JDBC_URL, Constants.SQL_USERNAME, Constants.SQL_PASSWORD);
        Base.openTransaction();
    }

    public static void commit() {
        Base.commitTransaction();
        Base.close();
    }

    public static void rollback() {
        Base.rollbackTransaction();
        Base.close();
    }
}
