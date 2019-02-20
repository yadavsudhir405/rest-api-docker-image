package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhiry on 2/17/19.
 */
@ConfigurationProperties(prefix = "rest-api.required-services", ignoreUnknownFields = true)
@Component
public class RequiredService {

    Map<DatabaseType, DataSourceConfig> dbs = new HashMap<>();

    public Map<DatabaseType, DataSourceConfig> getDbs() {
        return dbs;
    }

}
