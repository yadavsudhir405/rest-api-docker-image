package yadavsudhir405.rest.github.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sudhiry on 2/18/19.
 */
@Controller
public class ViewController {
    //@RequestMapping("/web1/**/{path:[^\\.]+}/")
   // @RequestMapping("/web1/**")
    public String forward() {
        return "forward:/web1/index.html";
    }
}
