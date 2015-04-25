package com.anprache.dao;

import org.javalite.activejdbc.Base;
import org.junit.After;
import org.junit.Before;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class BaseDaoTest {
    @Before
    public void setUp() throws Exception {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/myntra", "root", "");
        Base.openTransaction();
    }

    @After
    public void tearDown() throws Exception {
        Base.rollbackTransaction();
        Base.close();

    }

}
