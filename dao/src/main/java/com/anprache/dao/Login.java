package com.anprache.dao;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 * Created by pratyush.verma on 25/04/15.
 */
@Table("login")
public class Login extends Model {
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static String ACCOUNT_NUMBER = "account_number";


    static {
        validatePresenceOf(EMAIL, PASSWORD);
    }

    public int getAccountNumber() {
        return getInteger(ACCOUNT_NUMBER);
    }

    public String getEmail() {
        return (String) get(EMAIL);
    }

    public void setEmail(String email) {
        set(EMAIL, email);
    }

    public String getPassword() {
        return (String) get(PASSWORD);
    }

    public void setPassword(String password) {
        set(PASSWORD, password);
    }

}
