package yadavsudhir405.rest.github.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yadavsudhir405.rest.github.com.configurationProperty.*;
import yadavsudhir405.rest.github.com.service.UserService;

/**
 * Created by sudhiry on 1/25/19.
 */
@Configuration
public class RootConfig {

    private final UserService userService;
    @Value("${env}")
    private String env;


    private RequiredService requiredService;
    private RestApiProperties restApiProperties;

    public RootConfig(UserService userService,  RestApiProperties restApiProperties, RequiredService requiredService) {
        this.userService = userService;
        this.restApiProperties = restApiProperties;
        this.requiredService = requiredService;
    }

    @Bean
    public CommandLineRunner getCommandLiner(){
        return (args)->{
           this.restApiProperties.getWhiteListedFileType().stream().forEach(System.out::println);
        };
    }

    public String getEnv() {
        return "Hello "+env;
    }


}
