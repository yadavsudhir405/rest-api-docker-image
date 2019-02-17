package yadavsudhir405.rest.github.com.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by sudhiry on 2/16/19.
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/dumm/**").
                addResourceLocations("classpath:/dumm/")
                .setCacheControl(CacheControl.noCache());
        // any url of below pattern, content will be served from the mentioned localtion
        registry.addResourceHandler("/web1alias/**").addResourceLocations("file:/Users/sudhiry/yadavsudhir405/angularjs-es/dist/");
        registry.addResourceHandler("/web2/**").addResourceLocations("file:/opt/rest-api/web2/");

    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/web1/**").setViewName("forward:/web1alias/index.html");
        registry.addViewController("/web2").setViewName("forward:/web2/index.html");
        registry.addRedirectViewController("/apidocs","/swagger-ui.html");
    }


}
