package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.utils.QueryUtils;
import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.compare.PersonDifference;
import com.anprache.social.common.utils.CompareUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/people/compare")
public class ComparePeople {

    public ComparePeople() {

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDifference comparePeople(@QueryParam(Constants.SOURCE_ACCOUNT_ID)String sourceAccountId, @QueryParam(Constants.COMPARED_ACCOUNT_ID) String comparedAccountId) {
        List<String> personAProduct = QueryUtils.getLikedProducts(sourceAccountId).stream().map(String::valueOf).collect(Collectors.toList());
        List<String> personBProduct = QueryUtils.getLikedProducts(comparedAccountId).stream().map(String::valueOf).collect(Collectors.toList());
        double score = CompareUtils.compare(personAProduct, personBProduct);
        PersonDifference peopleDifference = new PersonDifference();
        peopleDifference.setPercentageDifference(String.valueOf(score));
        return peopleDifference;
    }
}
