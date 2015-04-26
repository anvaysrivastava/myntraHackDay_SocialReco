package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.Follow;
import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.FollowPersonResponse.FollowPersonResponse;
import com.anprache.social.common.pojo.signup.SignupResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 26/04/15.
 */
@Path("/report/follower")
public class FollowPerson {

    public FollowPerson() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public FollowPersonResponse reportFollower(@QueryParam(Constants.FOLLOWED_ACCOUNT_ID)String followedId, @QueryParam(Constants.FOLLOWER_ACCOUNT_ID)String followerId) {

        Follow follow = new Follow();
        follow.setFollowedBy(followerId);
        follow.setFollows(followedId);
        boolean success = follow.saveIt();

        if (success) {
            return new FollowPersonResponse("Success");
        }
        return new FollowPersonResponse("Failed");
    }

}
