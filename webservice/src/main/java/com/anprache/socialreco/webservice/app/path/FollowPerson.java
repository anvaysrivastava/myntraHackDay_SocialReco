package com.anprache.socialreco.webservice.app.path;

import com.anprache.social.common.constants.Constants;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
@Path("/report/follower")
public class FollowPerson {

    public FollowPerson() {
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String reportFollower(@QueryParam(Constants.FOLLOWED_ACCOUNT_ID)String followedId, @QueryParam(Constants.FOLLOWER_ACCOUNT_ID)String followerId){
        return "Success";
    }

}
