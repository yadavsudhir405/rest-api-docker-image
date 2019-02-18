package yadavsudhir405.rest.github.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yadavsudhir405.rest.github.com.configurationProperty.Admins;
import yadavsudhir405.rest.github.com.configurationProperty.Database;
import yadavsudhir405.rest.github.com.configurationProperty.Person;
import yadavsudhir405.rest.github.com.configurationProperty.WebApps;
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

    public RootConfig(UserService userService, Person person, Admins admins, Database databases, WebApps webapps) {
        this.userService = userService;
        this.person = person;
        this.admins = admins;
        this.databases = databases;
        this.webApps = webapps;
    }

    @Bean
    public CommandLineRunner getCommandLiner(){
        return (args)->{
            System.out.println("****"+ person.getName());
            this.admins.getPersons().stream().forEach(person1 -> System.out.println(person1.getName()+"\n"));
            this.databases.getDbs().keySet().stream().forEach(System.out::println);
            this.databases.getDbs().values().stream().forEach(System.out::println);
        };
    }

    public String getEnv() {
        return "Hello "+env;
    }


}
