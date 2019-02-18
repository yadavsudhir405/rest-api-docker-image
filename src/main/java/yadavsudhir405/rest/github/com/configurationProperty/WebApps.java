package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

/**
 * Created by sudhiry on 2/17/19.
 */
@ConfigurationProperties(prefix = "rest-api", ignoreUnknownFields = true)
public class WebApps {
    Set<WebApp> webAppConfigs;

    public Set<WebApp> getWebAppConfigs() {
        return webAppConfigs;
    }

    public void setWebAppConfigs(Set<WebApp> webAppConfigs) {
        this.webAppConfigs = webAppConfigs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebApps webApps = (WebApps) o;

        return webAppConfigs != null ? webAppConfigs.equals(webApps.webAppConfigs) : webApps.webAppConfigs == null;
    }

    @Override
    public int hashCode() {
        return webAppConfigs != null ? webAppConfigs.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WebApps{" +
                "webAppConfigs=" + webAppConfigs +
                '}';
    }
}
