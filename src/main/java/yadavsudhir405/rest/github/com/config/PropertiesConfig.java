package yadavsudhir405.rest.github.com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import yadavsudhir405.rest.github.com.configurationProperty.*;

/**
 * Created by sudhiry on 2/17/19.
 */
@Configuration
public class PropertiesConfig {

    @Bean
    public RequiredService databases(){
        return buildDefaultDatabases();
    }

    @Bean
    @ConfigurationProperties(prefix = "rest-api.required-services", ignoreUnknownFields = true)
    public RequiredService requiredService(){
        RequiredService requiredService = new RequiredService();
        requiredService.getDbs().put(DatabaseType.LOCALMONGO, new DataSourceConfig());
        return requiredService;
    }

    private RequiredService buildDefaultDatabases() {
        RequiredService requiredService =  new RequiredService();
        requiredService.getDbs().put(DatabaseType.LOCALMONGO, new DataSourceConfig());
        return requiredService;
    }

}
