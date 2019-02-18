package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class WebApp {
    private String app;
    @NestedConfigurationProperty
    private Config config;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

}
