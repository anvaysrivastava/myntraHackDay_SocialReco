package com.anprache.dao;

import com.anprache.Constants;
import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class BaseDaoTest {
    @Before
    public void setUp() throws Exception {
        Base.open(Constants.JDBC_DRIVER, Constants.JDBC_URL, Constants.SQL_USERNAME, Constants.SQL_PASSWORD);
        Base.openTransaction();
    }

    @After
    public void tearDown() throws Exception {
        Base.rollbackTransaction();
        Base.close();

    }

}
