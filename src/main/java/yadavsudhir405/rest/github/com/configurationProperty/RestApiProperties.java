package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.stereotype.Component;

import java.util.*;

import static yadavsudhir405.rest.github.com.configurationProperty.Sex.MALE;

/**
 * Created by sudhiry on 2/18/19.
 */
@ConfigurationProperties(
        prefix = "rest-api",
        ignoreUnknownFields = true
)
@Component
public class RestApiProperties {
    private static final Set<FileType> DEFAULT_FILE_TYPES =
            new HashSet<FileType>(Arrays.asList(FileType.values()));

    private static final List<Person> DEFAULT_ADMIN = Arrays.asList(defaultAdmin());

    @NestedConfigurationProperty
    private Person person = new Person();

    private Set<FileType> whiteListedFileType = DEFAULT_FILE_TYPES;

    private List<Person> admins = DEFAULT_ADMIN;

    private Set<WebApp> webApps = new HashSet<WebApp>();

    public Person getPerson() {
        return person;
    }

    public Set<FileType> getWhiteListedFileType() {
        return whiteListedFileType;
    }

    public void setWhiteListedFileType(Set<FileType> whiteListedFileType) {
        this.whiteListedFileType = whiteListedFileType;
    }

    public List<Person> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Person> admins) {
        this.admins = admins;
    }

    public Set<WebApp> getWebApps() {
        return webApps;
    }

    public void setWebApps(Set<WebApp> webApps) {
        this.webApps = webApps;
    }

    private static Person defaultAdmin() {
        Person person = new Person();
        person.setName("defaultAdmin");
        person.setAge(34);
        person.setSex(MALE);
        return person;
    }
}
