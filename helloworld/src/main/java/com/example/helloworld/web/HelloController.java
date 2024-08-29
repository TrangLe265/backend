package com.example.helloworld.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody; 
//annotation to tell this is controller accepting info from internet
@Controller 
//responsebody annotation means we return string 
@ResponseBody 
public class HelloController {
    //Requestmapping tell at what url/endpoint the method is ran
    @RequestMapping("/index") 
    public String main() { 
        return "This is the main page";
    } 

    @RequestMapping("/contact") 
    public String contact() { 
        return "This is the contact page";
    } 

    @RequestMapping("/hello")
    public String hello3(@RequestParam(name="location") String location, @RequestParam(name ="name") String name) {
        return "Welcome to the " + location+ " " + name;
    }
}
