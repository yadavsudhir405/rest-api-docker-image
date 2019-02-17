package yadavsudhir405.rest.github.com.configurationProperty;

import java.util.Map;

/**
 * Created by sudhiry on 2/17/19.
 */
public class Database {

    Map<String, DataSourceConfig> dbs;

    public Map<String, DataSourceConfig> getDbs() {
        return dbs;
    }

    public void setDbs(Map<String, DataSourceConfig> dbs) {
        this.dbs = dbs;
    }
}
