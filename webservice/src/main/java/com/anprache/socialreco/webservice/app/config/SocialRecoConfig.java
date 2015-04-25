package com.anprache.socialreco.webservice.app.config;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by anvay.srivastava on 25/04/15.
 */
public class SocialRecoConfig extends Configuration {
    @NotEmpty
    private String maintainer;

    public String getMaintainer() {
        return maintainer;
    }

    public void setMaintainer(String maintainer) {
        this.maintainer = maintainer;
    }
}
