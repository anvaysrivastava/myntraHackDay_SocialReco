package com.anprache.social.common.pojo.feed;

import java.util.List;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
public class FeedEntity {
    private String productId;
    private List<Person> peopleWhoLikedIt;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<Person> getPeopleWhoLikedIt() {
        return peopleWhoLikedIt;
    }

    public void setPeopleWhoLikedIt(List<Person> peopleWhoLikedIt) {
        this.peopleWhoLikedIt = peopleWhoLikedIt;
    }
}
