package com.anprache.socialreco.webservice.app.path;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by anvay.srivastava on 25/04/15.
 */

@Path("/HelloWorld")
public class Hello {

    @GET
    @Path("/BBCD")
    @Produces(MediaType.TEXT_PLAIN)
    public String verifyAndMergeSplitUpload() {
        return "Aa gaya harami";
    }
}
