package yadavsudhir405.rest.github.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yadavsudhir405.rest.github.com.config.ApplicationConfig;

/**
 * Created by sudhiry on 1/26/19.
 */
@RestController
@RequestMapping(path = "${api-version}/ping")
public class Ping {

    private final  ApplicationConfig applicationConfig;

    public Ping(ApplicationConfig applicationConfig) {
        this.applicationConfig = applicationConfig;
    }

    @GetMapping
    public String getPing(){
        return "Ping from "+ applicationConfig.getEnv();
    }
}
