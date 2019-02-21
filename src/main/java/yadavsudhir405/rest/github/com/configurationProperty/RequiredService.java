package yadavsudhir405.rest.github.com.configurationProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhiry on 2/17/19.
 */

public class RequiredService {
    Map<DatabaseType, DataSourceConfig> dbs = new HashMap<>();

    public Map<DatabaseType, DataSourceConfig> getDbs() {
        return dbs;
    }

}
