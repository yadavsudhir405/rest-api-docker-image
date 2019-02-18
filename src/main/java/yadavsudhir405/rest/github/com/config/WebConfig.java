package yadavsudhir405.rest.github.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yadavsudhir405.rest.github.com.configurationProperty.WebApp;
import yadavsudhir405.rest.github.com.configurationProperty.WebApps;

/**
 * Created by sudhiry on 2/16/19.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private WebApps webApps;
    private WebAppWebRequestInterceptor webAppWebRequestInterceptor;

    public WebConfig(WebApps webApps, WebAppWebRequestInterceptor webAppWebRequestInterceptor) {
        this.webApps = webApps;
        this.webAppWebRequestInterceptor = webAppWebRequestInterceptor;
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
      /* webApps.getWebAppConfigs().stream().forEach(webApp -> {
            registry.addViewController(getUrlPath(webApp)).setViewName(getViewName(webApp));
       });*/
       registry.addRedirectViewController("/apidocs","/swagger-ui.html");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addWebRequestInterceptor(this.webAppWebRequestInterceptor);
    }



    private String getRedirectUrl(WebApp webApp) {
        String defaultFileName = webApp.getConfig().getDefaultFileName();
        if(defaultFileName.startsWith("/")){
            defaultFileName = defaultFileName.substring(1);
        }
        return "/" +webApp.getApp()+"/"+defaultFileName;
    }

    private String getViewName(WebApp webApp) {
        String defaultFileName = webApp.getConfig().getDefaultFileName();
        if(defaultFileName.startsWith("/")){
            defaultFileName = defaultFileName.substring(1);
        }
        return "forward:/" +webApp.getApp()+"/"+defaultFileName;
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
        return  "/"+webApp.getApp()+"/**";
    }

}
