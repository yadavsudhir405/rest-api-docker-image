package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/18/19.
 */
@ConfigurationProperties(
        prefix = "rest-api",
        ignoreUnknownFields = true
)
public class RestApiProperties {
    @NestedConfigurationProperty
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
