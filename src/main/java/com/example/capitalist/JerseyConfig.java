package com.example.capitalist;

import org.springframework.stereotype.Component;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


@Component
@ApplicationPath("/adventureisis")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(Webservices.class);
        register(CORSResponseFilter.class);
    }

}

