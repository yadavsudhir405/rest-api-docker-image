package yadavsudhir405.rest.github.com.configurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class HostConfig {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HostConfig{" +
                "host='" + host + '\'' +
                ", port=" + port +
                '}';
    }
}
