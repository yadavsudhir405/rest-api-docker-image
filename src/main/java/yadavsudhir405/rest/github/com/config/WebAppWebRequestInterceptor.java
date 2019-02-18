package yadavsudhir405.rest.github.com.config;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.DispatcherServletWebRequest;
import yadavsudhir405.rest.github.com.configurationProperty.WebApp;
import yadavsudhir405.rest.github.com.configurationProperty.WebApps;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sudhiry on 2/18/19.
 */
@Component
public class WebAppWebRequestInterceptor implements WebRequestInterceptor {

    private final List<String> whiteListedFileTypes = Arrays.asList("html","js","css","jpg","jpeg","png");

    private WebApps webApps;

    public WebAppWebRequestInterceptor(WebApps webApps) {
        this.webApps = webApps;
    }

    @Override
    public void preHandle(WebRequest webRequest) throws Exception {
        HttpServletRequest request = ((DispatcherServletWebRequest) webRequest).getRequest();
        HttpServletResponse response =  ((DispatcherServletWebRequest) webRequest).getResponse();
        StringBuffer requestURL = request.getRequestURL();
        WebApp matchedWebApp = this.requestURLContainsUserDefinedWebAppApplicationContextPath(requestURL);
        if(null != matchedWebApp && !this.urlEndsWithByPassedFileTypes(requestURL)){
            String defaultPage = getDefaultPageToServeForWebApp(matchedWebApp);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(defaultPage);
            requestDispatcher.forward(request,response);
        }
    }

    private boolean urlEndsWithByPassedFileTypes(StringBuffer requestURL) {
        return whiteListedFileTypes.stream().filter(fileType -> requestURL.toString().endsWith(fileType))
                .collect(Collectors.toSet()).isEmpty() ? false : true;
    }

    @Override
    public void postHandle(WebRequest webRequest, @Nullable ModelMap modelMap) throws Exception {

    }

    @Override
    public void afterCompletion(WebRequest webRequest, @Nullable Exception e) throws Exception {

    }
    private WebApp requestURLContainsUserDefinedWebAppApplicationContextPath(StringBuffer requestURL) {
        List<WebApp> matchedWebApps = this.webApps.getWebAppConfigs().stream().filter(webApp -> requestURL.toString()
                .contains(webApp.getConfig().getApplicationContext())).collect(Collectors.toList());
        return matchedWebApps.isEmpty() ? null : matchedWebApps.get(0);

    }

    private String getDefaultPageToServeForWebApp(WebApp webApp){
        String defaultFileName = webApp.getConfig().getDefaultFileName();
        if(defaultFileName.startsWith("/")){
            defaultFileName = defaultFileName.substring(1);
        }
        return "/" +webApp.getApp()+"/"+defaultFileName;
    }
}
