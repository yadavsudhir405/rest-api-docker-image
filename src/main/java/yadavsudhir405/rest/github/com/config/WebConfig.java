package yadavsudhir405.rest.github.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yadavsudhir405.rest.github.com.configurationProperty.RestApiProperties;
import yadavsudhir405.rest.github.com.configurationProperty.WebApp;

import java.util.Set;

/**
 * Created by sudhiry on 2/16/19.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final Set<WebApp> webApps;
    private WebAppWebRequestInterceptor webAppWebRequestInterceptor;

    public WebConfig(RestApiProperties restApiProperties, WebAppWebRequestInterceptor webAppWebRequestInterceptor) {
        this.webApps = restApiProperties.getWebApps();
        this.webAppWebRequestInterceptor = webAppWebRequestInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        this.webApps.stream().forEach(webApp -> {
            registry.addResourceHandler(buildPathPatternForApp(webApp))
                    .addResourceLocations(buildResourceLocationForApp(webApp))
                    .setCacheControl(CacheControl.noCache()).resourceChain(true);
        });
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addRedirectViewController("/apidocs","/swagger-ui.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(this.webAppWebRequestInterceptor);
    }

    private String buildResourceLocationForApp(WebApp webApp) {
        String distroLocation = webApp.getConfig().getWebDistoDir();
        if(!distroLocation.endsWith("/")){
            distroLocation = distroLocation+"/";
        }
        if(!distroLocation.startsWith("file:/")){
            distroLocation = "file:/"+distroLocation;
        }
        return distroLocation;
    }

    private String buildPathPatternForApp(WebApp webApp) {
        return  "/"+webApp.getApp()+"/**";
    }

}
