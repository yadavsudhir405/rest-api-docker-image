package yadavsudhir405.rest.github.com.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yadavsudhir405.rest.github.com.configurationProperty.*;

import java.util.*;

import static yadavsudhir405.rest.github.com.configurationProperty.Sex.*;

/**
 * Created by sudhiry on 2/17/19.
 */
@Configuration
public class PropertiesConfig {

    @Bean
    public Person person(){
        Person person = new Person();
        person.setName("defaultName");
        person.setAge(40);
        person.setSex(MALE);
        return person;
    }
    @Bean
    public RestApiProperties restApiProperties(Person person){
        RestApiProperties restApiProperties = new RestApiProperties();
        restApiProperties.setPerson(person);
        return restApiProperties;
    }

    @Bean
    public Admins admin(){
        Admins admins = new Admins();
        List<Person> adminList = new ArrayList<>();
        adminList.add(defaultAdmin());
        admins.setAdmins(adminList);
        return admins;
    }

    @Bean
    @ConfigurationProperties()
    public Database databases(){
        return buildDefaultDatabases();
    }

    @Bean
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
