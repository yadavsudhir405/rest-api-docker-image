package yadavsudhir405.rest.github.com.configurationProperty;

import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by sudhiry on 2/17/19.
 */
public class WebApp {
    private String app;
    @NestedConfigurationProperty
    private Config config;

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }

    public static class Config{
        private String applicationContext;
        private String webDistoDir;
        private String defaultFileName;

        public String getApplicationContext() {
            return applicationContext;
        }

        public void setApplicationContext(String applicationContext) {
            this.applicationContext = applicationContext;
        }

        public String getWebDistoDir() {
            return webDistoDir;
        }

        public void setWebDistoDir(String webDistoDir) {
            this.webDistoDir = webDistoDir;
        }

        public String getDefaultFileName() {
            return defaultFileName;
        }

        public void setDefaultFileName(String defaultFileName) {
            this.defaultFileName = defaultFileName;
        }

    }

}
