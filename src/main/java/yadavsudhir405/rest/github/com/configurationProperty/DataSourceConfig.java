package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class DataSourceConfig {
    private static final String DEFAULT_USERNAME = "admin";
    private static final String DEFAULT_PASSWORD = "admin";

    private String username = DEFAULT_USERNAME;
    private String password = DEFAULT_PASSWORD;

    @NestedConfigurationProperty
    private HostConfig host = new HostConfig();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HostConfig getHost() {
        return host;
    }


    @Override
    public String toString() {
        return "DataSourceConfig{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host=" + host +
                '}';
    }
}
