package yadavsudhir405.rest.github.com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yadavsudhir405.rest.github.com.configurationProperty.*;

import java.util.*;

/**
 * Created by sudhiry on 2/17/19.
 */
@Configuration
public class PropertiesConfig {

    @Bean
    @ConfigurationProperties("person")
    public Person person(){
        Person person = new Person();
        person.setName("defaultName");
        person.setAge(40);
        return person;
    }

    @Bean
    @ConfigurationProperties("admins")
    public Admins admin(){
        Admins admins = new Admins();
        List<Person> adminList = new ArrayList<>();
        adminList.add(defaultAdmin());
        admins.setPersons(adminList);
        return admins;
    }

    @Bean
    @ConfigurationProperties()
    public Database databases(){
        return buildDefaultDatabases();
    }

    @Bean
    @ConfigurationProperties
    public WebApps webApps(){
        return newEmptyWebApps();
    }

    private Person defaultAdmin(){
        Person person = new Person();
        person.setName("default Admin");
        person.setAge(50);
        return person;
    }

    private WebApps newEmptyWebApps() {
        WebApps webApps = new WebApps();
        webApps.setWebAppConfigs(new HashSet<>());
        return webApps;
    }

    private Set<WebApp> defaultWepAppConfig() {
        Set<WebApp> webApps = new HashSet<>();
        webApps.add(defaultWepApp());
        return webApps;
    }

    private WebApp defaultWepApp() {
        WebApp webApp = new WebApp();
        webApp.setApp("defaultWebApp");
        webApp.setConfig(defaultConfig());
        return webApp;
    }

    private Map<String, WebApp.Config> defaultConfig() {
        Map<String, WebApp.Config> map = new HashMap<>();
        WebApp.Config config = new WebApp.Config();
        config.setApplicationContext("/default");
        config.setWebDistoDir("/opt");
        config.setDefaultFileName("index.html");
        map.put("defaultWepApp",config);
        return map;
    }

    private Database buildDefaultDatabases() {
        Database database =  new Database();
        Map<String, DataSourceConfig> dataSources = new HashMap<>();
        DataSourceConfig defaultDatasourceConfig = newDefaultDatasourceConfig();
        dataSources.put("defaultDataSource", defaultDatasourceConfig);
        database.setDbs(dataSources);
        return database;
    }

    private DataSourceConfig newDefaultDatasourceConfig() {
        DataSourceConfig dataSourceConfig =  new DataSourceConfig();
        dataSourceConfig.setUsername("default");
        dataSourceConfig.setPassword("default");
        dataSourceConfig.setHost(newDefaultHost());
        return dataSourceConfig;
    }

    private HostConfig newDefaultHost() {
        HostConfig hostConfig = new HostConfig();
        hostConfig.setHost("localhost");
        hostConfig.setPort(8080);
        return hostConfig;
    }

}
