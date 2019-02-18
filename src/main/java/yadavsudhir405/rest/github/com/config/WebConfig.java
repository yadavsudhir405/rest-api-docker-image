package yadavsudhir405.rest.github.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceResolverChain;
import yadavsudhir405.rest.github.com.configurationProperty.WebApp;
import yadavsudhir405.rest.github.com.configurationProperty.WebApps;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * Created by sudhiry on 2/16/19.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private WebApps webApps;

    public WebConfig(WebApps webApps) {
        this.webApps = webApps;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        webApps.getWebAppConfigs().stream().forEach(webApp -> {
            registry.addResourceHandler(buildPathPatternForApp(webApp))
                    .addResourceLocations(buildResourceLocationForApp(webApp))
                    .setCacheControl(CacheControl.noCache()).resourceChain(true);
        });
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       webApps.getWebAppConfigs().stream().forEach(webApp -> {
            registry.addViewController(getUrlPath(webApp)).setViewName(getViewName(webApp));
       });
       registry.addRedirectViewController("/apidocs","/swagger-ui.html");
    }

    private String getViewName(WebApp webApp) {
        String defaultFileName = webApp.getConfig().getDefaultFileName();
        if(defaultFileName.startsWith("/")){
            defaultFileName = defaultFileName.substring(1);
        }
        return "forward:/" +webApp.getApp()+"as/"+defaultFileName;
    }

    private String getUrlPath(WebApp webApp) {
        String applicationContext = webApp.getConfig().getApplicationContext();
        if(!applicationContext.startsWith("/")){
            applicationContext = "/"+applicationContext;
        }
        if(!applicationContext.endsWith("/")){
            applicationContext = applicationContext+ "/";
        }
        return applicationContext+"**";
    }
    private String buildResourceLocationForApp(WebApp webApp) {
        String distroLocation = webApp.getConfig().getWebDistoDir();
        if(!distroLocation.endsWith("/")){
            distroLocation = distroLocation+"/";
        }
        if(!distroLocation.startsWith("/")){
            distroLocation = "/"+distroLocation;
        }
        return "file:"+distroLocation;
    }

    private String buildPathPatternForApp(WebApp webApp) {
        return  "/"+webApp.getApp()+"as/**";
    }

}
