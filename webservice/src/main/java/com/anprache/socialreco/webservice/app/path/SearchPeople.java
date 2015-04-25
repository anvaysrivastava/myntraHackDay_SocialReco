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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

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
            LinkedHashSet personBProduct = QueryUtils.getLikedProducts(anotherUser.getAccountId());
            double score = CompareUtils.compare(personAProduct, personBProduct);
            PersonInRespectOfAnotherPerson anotherPerson = new PersonInRespectOfAnotherPerson();
            anotherPerson.setPerson(new Person(anotherUser.getName(), anotherUser.getAccountId()));
            anotherPerson.setPersonDifference(new PersonDifference(String.valueOf(score)));
            response.add(anotherPerson);
        }

        return response;
    }

}
