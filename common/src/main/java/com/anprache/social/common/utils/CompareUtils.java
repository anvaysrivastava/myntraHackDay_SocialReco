package com.anprache.social.common.utils;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class CompareUtils {
    public static double compare(LinkedHashSet productFollowedByA, LinkedHashSet productFollowedByB) {
        LinkedHashSet similar = new LinkedHashSet(productFollowedByA);
        similar.retainAll(productFollowedByB);
        return ((double) similar.size() / (double) productFollowedByA.size()) * 100.0;
    }
}
