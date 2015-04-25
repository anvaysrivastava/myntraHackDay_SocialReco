package com.anprache.dao;

import com.anprache.dao.utils.DBUtils;
import org.junit.After;
import org.junit.Before;

/**
 * Created by pratyush.verma on 25/04/15.
 */
public class BaseDaoTest {
    @Before
    public void setUp() throws Exception {
        DBUtils.init();
    }

    @After
    public void tearDown() throws Exception {
        DBUtils.rollback();
    }

}
