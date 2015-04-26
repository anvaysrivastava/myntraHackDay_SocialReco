package com.anprache.socialreco.webservice.app.path;

import com.anprache.social.common.constants.Constants;
import com.anprache.social.common.pojo.feed.FeedEntity;
import com.anprache.social.common.pojo.feed.Person;
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
@Path("/fetch/feed")
public class Feed {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FeedEntity> getFeed(@QueryParam(Constants.ACCOUNT_ID) String accountId) {
        List<FeedEntity> feeds = Lists.newArrayList();
        //Mocked Response starts
        for (int i = 0; i < 10; i++) {
            FeedEntity feedEntity = new FeedEntity();
            feedEntity.setProductId(String.format("12345%d", i));
            List<Person> personList = Lists.newArrayList();
            for (int j = 0; j < 1; j++) {
                personList.add(new Person(String.format("Person %d%d", i, j)));
            }
            feedEntity.setPeopleWhoLikedIt(personList);
            feeds.add(feedEntity);
        }

        //Mocked Response ends

        return feeds;

    }
}
