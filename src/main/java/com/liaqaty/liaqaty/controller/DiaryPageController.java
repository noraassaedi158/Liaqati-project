package com.liaqaty.liaqaty.controller;
import java.time.LocalDate;
import java.time.LocalTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import com.liaqaty.liaqaty.service.WorkoutService;
@Controller

@RequestMapping("/diary")
public class DiaryPageController {

    private final WorkoutService workoutService;

    public DiaryPageController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }
    @GetMapping
    public String showDiary(Model model) {
        model.addAttribute("workouts", workoutService.getAllWorkouts());
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("currentTime", LocalTime.now());

        return "diary";
    }
}

