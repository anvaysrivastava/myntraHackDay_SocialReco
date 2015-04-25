package com.anprache.social.common.utils;

import java.util.Collections;
import java.util.List;

/**
 * Created by pratyush.verma on 26/04/15.
 */
public class CompareUtils {
    public static double compare(List<String> productFollowedByA, List<String> productFollowedByB) {
        Collections.sort(productFollowedByA);
        Collections.sort(productFollowedByB);
        int common = 0;
        for (String product : productFollowedByA) {
            if (productFollowedByB.contains(product)) {
                common++;
            }
        }
        return (common / (double) productFollowedByA.size()) * 100.0;
    }
}
