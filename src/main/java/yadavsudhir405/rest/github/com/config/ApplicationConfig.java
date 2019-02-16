package yadavsudhir405.rest.github.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yadavsudhir405.rest.github.com.document.User;
import yadavsudhir405.rest.github.com.service.UserService;

/**
 * Created by sudhiry on 1/25/19.
 */
@Configuration
public class ApplicationConfig {

    private final UserService userService;
    @Value("${env}")
    private String env;

    public ApplicationConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public CommandLineRunner getCommandLiner(){
        return (args)->{
          //  this.userService.save(new User(args[0], args[1]));
        };
    }

    public String getEnv() {
        return "Hello "+env;
    }
}
