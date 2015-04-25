package com.anprache.socialreco.webservice.app.path;

import com.anprache.dao.Follow;
import com.anprache.dao.User;
import com.anprache.dao.utils.QueryUtils;
import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.compare.PersonDifference;
import com.anprache.social.common.pojo.feed.Person;
import com.anprache.social.common.pojo.feed.PersonInRespectOfAnotherPerson;
import com.anprache.social.common.utils.CompareUtils;
import com.google.common.collect.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
@Path("/fetch/followed/people")
public class FetchFollowedPeople {

    public FetchFollowedPeople() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonInRespectOfAnotherPerson> getRecommendedPeople(@QueryParam(Constants.ACCOUNT_ID) String accountId) {
        List<PersonInRespectOfAnotherPerson> recommendation = Lists.newArrayList();
        List<Follow> followList = QueryUtils.getFollowingPeople(accountId);
        LinkedHashSet personAProduct = QueryUtils.getLikedProducts(accountId);

        for (Follow follow : followList) {
            LinkedHashSet personBProduct = QueryUtils.getLikedProducts(follow.getFollows());

            double difference = CompareUtils.compare(personAProduct, personBProduct);
            User anotherUser = QueryUtils.getUser(follow.getFollows());

            PersonInRespectOfAnotherPerson anotherPerson = new PersonInRespectOfAnotherPerson();
            anotherPerson.setPerson(new Person(anotherUser.getName(), anotherUser.getAccountId(), anotherUser.getImage()));
            anotherPerson.setPersonDifference(new PersonDifference(String.valueOf(difference)));

            recommendation.add(anotherPerson);
        }

        return recommendation;
    }

}
