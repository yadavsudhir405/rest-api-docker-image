package yadavsudhir405.rest.github.com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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


    private RequiredService buildDefaultDatabases() {
        RequiredService requiredService =  new RequiredService();
        requiredService.getDbs().put(DatabaseType.LOCALMONGO, new DataSourceConfig());
        return requiredService;
    }

}
