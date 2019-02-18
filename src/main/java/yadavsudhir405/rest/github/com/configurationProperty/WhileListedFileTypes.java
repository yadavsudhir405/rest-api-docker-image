package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sudhiry on 2/18/19.
 */
@ConfigurationProperties(
        prefix = "rest-api"
)
@Configuration
public class WhileListedFileTypes {

    private static final Set<String> DEFAULT_FILE_TYPES =
            new HashSet<>(Arrays.asList("html","css","js","jpg","jpeg","png"));

    private Set<String> whiteListedFileType = DEFAULT_FILE_TYPES;

    public Set<String> getWhiteListedFileType() {
        return whiteListedFileType;
    }

    public void setWhiteListedFileType(Set<String> whiteListedFileType) {
        this.whiteListedFileType = whiteListedFileType;
    }
}
