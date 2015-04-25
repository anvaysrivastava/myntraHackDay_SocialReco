package com.anprache.socialreco.webservice.app.path;

import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.feed.PersonInRespectOfAnotherPerson;
import com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/search/people")
public class SearchPeople {
    public SearchPeople() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonInRespectOfAnotherPerson> searchPeople(@QueryParam(Constants.SEARCH_STRING) String searchString) {
        List<PersonInRespectOfAnotherPerson> response = Lists.newArrayList();

        return response;
    }

}
