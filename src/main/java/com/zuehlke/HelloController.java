package com.zuehlke;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by adni on 10.05.17.
 */
@Controller
public class HelloController {


    @GetMapping("/hello")
    @ResponseBody
    public String home() {
        return "Hello World!";
    }

}