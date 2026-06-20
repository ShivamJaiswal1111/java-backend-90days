package com.spring_learn.FirstApp.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    public String greet(){
        return "Welocome to MyApp!";
    }

    @RequestMapping("/about")
    public String abouttt(){
        return "This is about section !!";
    }


}
