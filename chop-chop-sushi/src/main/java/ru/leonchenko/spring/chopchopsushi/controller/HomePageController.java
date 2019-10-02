package ru.leonchenko.spring.chopchopsushi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Controller
public class HomePageController {

    @RequestMapping("/")
    public String home(){
        return "Home Page";
    }


}
