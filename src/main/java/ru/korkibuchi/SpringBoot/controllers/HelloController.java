package ru.korkibuchi.SpringBoot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "/hello";
    }
}
