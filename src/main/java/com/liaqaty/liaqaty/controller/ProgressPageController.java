
package com.liaqaty.liaqaty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//this class just displays the page, and pass ID to js to get Data
@Controller
@RequestMapping("/progress")
public class ProgressPageController {
    @GetMapping("/{userId}")
    public String showProgress(
            @PathVariable Integer userId,
            Model model) {
        model.addAttribute("userId", userId);
        return "progress";
    }
}
