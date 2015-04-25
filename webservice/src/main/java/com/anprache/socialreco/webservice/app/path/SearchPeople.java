package com.anprache.socialreco.webservice.app.path;

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
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
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
    public List<PersonInRespectOfAnotherPerson> searchPeople(@QueryParam(Constants.ACCOUNT_ID) String searchAccountId, @QueryParam(Constants.SEARCH_STRING) String searchString) {
        List<PersonInRespectOfAnotherPerson> response = Lists.newArrayList();

        List<User> users = QueryUtils.getUsers(searchString);
        LinkedHashSet personAProduct = QueryUtils.getLikedProducts(searchAccountId);

        for (User anotherUser : users) {
            if (anotherUser.getAccountId().equals(searchAccountId)) {
                continue;
            }
            LinkedHashSet personBProduct = QueryUtils.getLikedProducts(anotherUser.getAccountId());

            double score = CompareUtils.compare(personAProduct, personBProduct);
            PersonInRespectOfAnotherPerson anotherPerson = new PersonInRespectOfAnotherPerson();
            anotherPerson.setPerson(new Person(anotherUser.getName(), anotherUser.getAccountId()));
            anotherPerson.setPersonDifference(new PersonDifference(String.valueOf(score)));
            response.add(anotherPerson);
        }

        Collections.sort(response, new Comparator<PersonInRespectOfAnotherPerson>() {
            @Override
            public int compare(PersonInRespectOfAnotherPerson o1, PersonInRespectOfAnotherPerson o2) {
                return Double.parseDouble(o1.getPersonDifference().getPercentageDifference()) - Double.parseDouble(o2.getPersonDifference().getPercentageDifference()) > 0 ? -1 : 1;
            }
        });

        return response;
    }

}
