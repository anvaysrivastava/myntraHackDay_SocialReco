package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.LikeDislike;
import com.anprache.social.common.constants.Constants;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/register/product/swipe")
public class RegisterProductSwipe {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String action(@QueryParam(Constants.ACCOUNT_ID)String accountId, @QueryParam(Constants.PRODUCT_ID) String productId, @QueryParam(Constants.SWIPE_RESPONSE)Boolean swipeResponse ){
        //TODO insertion logic here.
        if (Boolean.TRUE.equals(swipeResponse)) {
            LikeDislike likeDislike = new LikeDislike();
            likeDislike.setAccountId(accountId);
            likeDislike.setProductId(Integer.parseInt(productId));
            boolean success = likeDislike.saveIt();
            if (success) {
                return "SUCCESS";
            }
            return "ERROR";
        }
        return "DISLIKE NOT SUPPORTED YET!";
    }

}
