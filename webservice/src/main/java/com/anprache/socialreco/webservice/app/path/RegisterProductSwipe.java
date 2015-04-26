package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.Follow;
import com.anprache.dao.LikeDislike;
import com.anprache.dao.Stream;
import com.anprache.dao.utils.QueryUtils;
import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.FollowPersonResponse.FollowPersonResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/register/product/swipe")
public class RegisterProductSwipe {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public FollowPersonResponse action(@QueryParam(Constants.ACCOUNT_ID)String accountId, @QueryParam(Constants.PRODUCT_ID) String productId, @QueryParam(Constants.SWIPE_RESPONSE)Boolean swipeResponse ){
        //TODO insertion logic here.
        if (Boolean.TRUE.equals(swipeResponse)) {
            LikeDislike likeDislike = new LikeDislike();
            likeDislike.setAccountId(accountId);
            likeDislike.setProductId(Integer.parseInt(productId));
            likeDislike.setStatus("NOT_PROCESSED");
            boolean success = likeDislike.saveIt();
            if(success){
                List<Follow> peoples = QueryUtils.getFollowingPeople(accountId);
                for (Follow people : peoples) {
                    Stream stream = new Stream();
                    stream.setFromAccountId(people.getFollows());
                    stream.setForAccountId(people.getFollowedBy());
                    stream.setProductId(Integer.parseInt(productId));
                    stream.saveIt();
                }
            }
            if (success) {
                return new FollowPersonResponse("SUCCESS");
            }
            return new FollowPersonResponse("ERROR");
        }
        return new FollowPersonResponse("DISLIKE NOT SUPPORTED YET!");
    }

}
