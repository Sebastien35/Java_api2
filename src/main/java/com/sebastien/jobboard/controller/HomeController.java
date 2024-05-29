package com.sebastien.jobboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping(path="/")
    public String  greet(){
        return "Publicly available endpoint";

    }

    @GetMapping(path="/secured")
    public String secured(){
        return ("secured endpoint");
    }
}
