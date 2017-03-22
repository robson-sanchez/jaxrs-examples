package br.com.rvvsanchez.api.rest.jaxrs.server;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig {
  
  @Bean
  public ResourceConfig resources() {
    ResourceConfig config = new ResourceConfig();
    config.register(JacksonFeature.class);
    config.packages("br.com.rvvsanchez.api.rest.jaxrs.server");
    
    return config;
  }
  
}
