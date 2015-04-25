package com.anprache.social.common.pojo.feed;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
    private String name;
    private String accountId;


    public Person() {
    }

    public Person(String name, String accountId) {
        this.name = name;
        this.accountId = accountId;
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}
