package com.anprache.socialreco.webservice.app.healthcheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by anvay.srivastava on 06/02/15.
 */
public class ConfigHealthCheck extends HealthCheck {

    public ConfigHealthCheck() {
    }


    @Override
    protected Result check() throws Exception {
        return Result.healthy();
    }
}
