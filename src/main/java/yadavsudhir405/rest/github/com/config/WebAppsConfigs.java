package yadavsudhir405.rest.github.com.config;

import java.util.Set;

/**
 * Created by sudhiry on 2/17/19.
 */
public class WebAppsConfigs {
    Set<WebAppConfig> webAppConfigs;

    public WebAppsConfigs(Set<WebAppConfig> webAppConfigs) {
        this.webAppConfigs = webAppConfigs;
    }

    public Set<WebAppConfig> getWebAppConfigs() {
        return webAppConfigs;
    }

    public void setWebAppConfigs(Set<WebAppConfig> webAppConfigs) {
        this.webAppConfigs = webAppConfigs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebAppsConfigs that = (WebAppsConfigs) o;

        return webAppConfigs != null ? webAppConfigs.equals(that.webAppConfigs) : that.webAppConfigs == null;
    }

    @Override
    public int hashCode() {
        return webAppConfigs != null ? webAppConfigs.hashCode() : 0;
    }
}
