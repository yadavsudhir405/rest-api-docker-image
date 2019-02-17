package yadavsudhir405.rest.github.com.config;

/**
 * Created by sudhiry on 2/17/19.
 */
public class WebAppConfig {
    private String applicationContext;
    private String webDistoDir;
    private String defaultFileName;

    public WebAppConfig(String applicationContext, String webDistoDir, String defaultFileName) {
        this.applicationContext = applicationContext;
        this.webDistoDir = webDistoDir;
        this.defaultFileName = defaultFileName;
    }

    public String getApplicationContext() {
        return applicationContext;
    }

    public String getWebDistoDir() {
        return webDistoDir;
    }

    public String getDefaultFileName() {
        return defaultFileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebAppConfig that = (WebAppConfig) o;

        if (applicationContext != null ? !applicationContext.equals(that.applicationContext) : that.applicationContext != null) return false;
        if (webDistoDir != null ? !webDistoDir.equals(that.webDistoDir) : that.webDistoDir != null) return false;
        return defaultFileName != null ? defaultFileName.equals(that.defaultFileName) : that.defaultFileName == null;
    }

    @Override
    public int hashCode() {
        int result = applicationContext != null ? applicationContext.hashCode() : 0;
        result = 31 * result + (webDistoDir != null ? webDistoDir.hashCode() : 0);
        result = 31 * result + (defaultFileName != null ? defaultFileName.hashCode() : 0);
        return result;
    }
}
