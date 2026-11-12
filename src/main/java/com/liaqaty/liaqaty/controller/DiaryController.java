package com.liaqaty.liaqaty.controller;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.liaqaty.liaqaty.service.WorkoutService;
@Controller
@RequestMapping("/diary")
public class DiaryController {

    private final WorkoutService workoutService;

    public DiaryController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public String showDiary(Model model) {

        model.addAttribute("workouts", workoutService.getAllWorkouts());
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("currentTime", LocalTime.now());

        return "diary";
    }

    @PostMapping
    public String saveDiary(
            @RequestParam Integer userId,
            @RequestParam Integer workoutId,
            @RequestParam Integer minutes,
            @RequestParam LocalDate date,
            @RequestParam LocalTime time) {

        LocalDateTime completionDate = LocalDateTime.of(date, time);

        workoutService.saveWorkoutLog(userId, workoutId, minutes);

        return "redirect:/history/" + userId;
    }
}
