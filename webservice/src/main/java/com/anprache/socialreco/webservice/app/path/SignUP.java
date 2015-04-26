package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.User;
import com.anprache.dao.utils.DBUtils;
import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.signup.SignupResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/people/signup")
public class SignUP {

    public SignUP(){

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public SignupResponse signUp(@QueryParam(Constants.ACCOUNT_ID) String accountId, @QueryParam(Constants.NAME) String name, @QueryParam(Constants.IMAGE)String image){

        User user = new User();
        user.setAccountId(accountId);
        user.setName(name);
        user.setImage(image);
        boolean success = user.saveIt();

        return new SignupResponse( success ? "SUCCESS" : "FAILED");
    }



}
