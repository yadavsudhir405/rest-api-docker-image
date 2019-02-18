package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * Created by sudhiry on 2/17/19.
 */
@ConfigurationProperties(prefix = "rest-api", ignoreUnknownFields = true)
public class Admins {
    List<Person> admins;

    public List<Person> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Person> admins) {
        this.admins = admins;
    }
}
