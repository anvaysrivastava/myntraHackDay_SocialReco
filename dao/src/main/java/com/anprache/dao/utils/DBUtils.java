package com.anprache.dao.utils;

import org.javalite.activejdbc.Base;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class DBUtils {
    public static void init() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/myntra", "root", "");
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
