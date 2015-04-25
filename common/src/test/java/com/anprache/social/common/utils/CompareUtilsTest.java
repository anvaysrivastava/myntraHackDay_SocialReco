package com.anprache.social.common.utils;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class CompareUtilsTest {

    @Test
    public void testCompare() throws Exception {
        LinkedHashSet a = new LinkedHashSet();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        LinkedHashSet b = new LinkedHashSet();
        b.add(3);
        b.add(4);
        System.out.println(CompareUtils.compare(a,b));
        Assert.assertTrue(CompareUtils.compare(a, b) == 50.0);
    }
}