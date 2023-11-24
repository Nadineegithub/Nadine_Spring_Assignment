package com.example.student_mis.controller.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/nav")
    public String nav(){
        return "nav-bar";
    }
}
