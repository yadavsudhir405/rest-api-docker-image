package yadavsudhir405.rest.github.com.configurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class HostConfig {
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 27017;
    private String host = DEFAULT_HOST;
    private int port = DEFAULT_PORT;

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
