package com.anprache.social.common.pojo.signup;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
public class SignupResponse {
    private String status;

    public SignupResponse(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
