package com.liaqaty.liaqaty.controller;

import org.springframework.web.bind.annotation.*;

import com.liaqaty.liaqaty.DTO.CalorieDTO;
import com.liaqaty.liaqaty.service.CalorieService;

@RestController
@RequestMapping("/api/calories")
public class CalorieController {

    private final CalorieService calorieService;

    public CalorieController(CalorieService calorieService) {
        this.calorieService = calorieService;
    }

    @PostMapping("/calculate")
    public CalorieDTO calculateCalories(
            @RequestBody CalorieDTO data) {

        return calorieService.calculateCalories(data);
    }
}
