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

    private Person person;
    private Admins admins;
    private Database databases;
    private WebApps  webApps;
    private WhileListedFileTypes whileListedFileTypes;

    public RootConfig(UserService userService, Person person, Admins admins, Database databases,
                      WebApps webapps, WhileListedFileTypes whileListedFileTypes) {
        this.userService = userService;
        this.person = person;
        this.admins = admins;
        this.databases = databases;
        this.webApps = webapps;
        this.whileListedFileTypes =  whileListedFileTypes;
    }

    @Bean
    public CommandLineRunner getCommandLiner(){
        return (args)->{
           this.whileListedFileTypes.getWhiteListedFileType().stream().forEach(System.out::println);
        };
    }

    public String getEnv() {
        return "Hello "+env;
    }


}
