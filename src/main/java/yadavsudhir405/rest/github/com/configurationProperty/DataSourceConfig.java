package yadavsudhir405.rest.github.com.configurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class DataSourceConfig {
    private String username;
    private String password;
    private HostConfig host;

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

    public void setHost(HostConfig host) {
        this.host = host;
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
