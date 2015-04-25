package com.anprache.socialreco.webservice.app;

import com.anprache.socialreco.webservice.app.config.SocialRecoConfig;
import com.anprache.socialreco.webservice.app.healthcheck.ConfigHealthCheck;
import com.anprache.socialreco.webservice.app.path.ComparePeople;
import com.anprache.socialreco.webservice.app.path.Feed;
import com.anprache.socialreco.webservice.app.path.Hello;
import com.anprache.socialreco.webservice.app.path.RegisterProductSwipe;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
public class SocialReco extends Application<SocialRecoConfig> {

    public static void main(String args[]) throws Exception {
        new SocialReco().run(args);
    }

    @Override
    public void initialize(Bootstrap<SocialRecoConfig> bootstrap) {

    }

    @Override
    public void run(SocialRecoConfig configuration, Environment environment) throws Exception {
        //Register HealthCheck starts
        environment.healthChecks().register("configHealthCheck", new ConfigHealthCheck());
        //Register healthCheck ends

        //Register the path
        final Hello hello = new Hello();
        environment.jersey().register(hello);

        RegisterProductSwipe registerProductSwipe = new RegisterProductSwipe();
        environment.jersey().register(registerProductSwipe);

        Feed feed = new Feed();
        environment.jersey().register(feed);

        ComparePeople comparePeople = new ComparePeople();
        environment.jersey().register(comparePeople);
        //Register the path ends


    }
}
