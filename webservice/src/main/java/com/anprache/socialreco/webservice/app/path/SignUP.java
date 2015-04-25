package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.User;
import com.anprache.dao.utils.DBUtils;
import com.anprache.social.common.constants.Constants;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/people/signup")
public class SignUP {

    public SignUP(){

    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String signUp(@QueryParam(Constants.ACCOUNT_ID) String accountId, @QueryParam(Constants.NAME) String name){

        User user = new User();
        user.setAccountId(accountId);
        user.setName(name);
        boolean success = user.saveIt();

        return success ? "SUCCESS" : "FAILED";
    }



}
