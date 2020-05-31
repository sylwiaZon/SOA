package pl.edu.agh.soa.rest;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    public ApplicationConfig() {
        initializeSwagger();
    }

    private void initializeSwagger() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath("/rest-api/api");
        beanConfig.setResourcePackage("pl.edu.agh.soa.rest");
        beanConfig.setTitle("Student service documentation");
        beanConfig.setScan(true);
    }
}