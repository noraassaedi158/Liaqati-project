package com.liaqaty.liaqaty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class WarmupsController {

    @GetMapping("/warmups")
    public String showWarmupsPage() {
        return "warmups";
    }
}
