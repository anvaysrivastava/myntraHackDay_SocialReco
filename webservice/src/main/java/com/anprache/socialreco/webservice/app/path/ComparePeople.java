package com.anprache.socialreco.webservice.app.path;

import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.compare.PeopleDifference;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/people/compare")
public class ComparePeople {

    public ComparePeople() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PeopleDifference comparePeople(@QueryParam(Constants.SOURCE_ACCOUNT_ID)String sourceAccountId, @QueryParam(Constants.COMPARED_ACCOUNT_ID) String comparedAccountId) {
        PeopleDifference peopleDifference = new PeopleDifference();
        peopleDifference.setPercentageDifference("19.23");
        return peopleDifference;
    }
}
