package com.anprache.socialreco.webservice.app.path;

import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.compare.PersonDifference;
import com.anprache.social.common.pojo.feed.Person;
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
@Path("/fetch/followed/people")
public class FetchFollowedPeople {

    public FetchFollowedPeople() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonInRespectOfAnotherPerson> getRecommendedPeople(@QueryParam(Constants.ACCOUNT_ID) String accountId) {
        List<PersonInRespectOfAnotherPerson> dummyResponse = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            PersonInRespectOfAnotherPerson personInRespectOfAnotherPerson = new PersonInRespectOfAnotherPerson();
            Person person = new Person();
            person.setName(String.format("This is person %d", i));
            person.setAccountId(String.format("ACCOUNTID.NO:%d",i));
            personInRespectOfAnotherPerson.setPerson(person);
            PersonDifference personDifference = new PersonDifference();
            personDifference.setPercentageDifference(String.format("1%d.%d%d", i, i, i));
            personInRespectOfAnotherPerson.setPersonDifference(personDifference);
            dummyResponse.add(personInRespectOfAnotherPerson);
        }
        return  dummyResponse;
    }

}
