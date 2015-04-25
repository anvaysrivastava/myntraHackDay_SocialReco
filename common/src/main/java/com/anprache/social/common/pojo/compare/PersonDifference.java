package com.anprache.social.common.pojo.compare;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
public class PersonDifference {
    private String percentageDifference;

    public PersonDifference() {
    }

    public PersonDifference(String percentageDifference) {
        this.percentageDifference = percentageDifference;
    }

    public String getPercentageDifference() {
        return percentageDifference;
    }

    public void setPercentageDifference(String percentageDifference) {
        this.percentageDifference = percentageDifference;
    }
}
