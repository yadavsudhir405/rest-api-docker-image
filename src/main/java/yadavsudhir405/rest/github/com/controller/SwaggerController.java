package yadavsudhir405.rest.github.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sudhiry on 2/16/19.
 */
@Controller
public class SwaggerController {
    @RequestMapping("/apidocs/**")
    public String serverSwaggerHtml(){
        return "forward:swagger-ui.html";
    }
}
