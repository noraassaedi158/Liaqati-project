package com.liaqaty.liaqaty.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.service.WorkoutService;

@Controller
//makes page Spring MVC(model, view, comtroller) and this page can return view
public class HistoryController {
    //make an workout Service object and add all dependencies because we inject the constructor 
    private final WorkoutService workoutService;
    public HistoryController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping("/history/{userId}")
    public String showHistory(@PathVariable Integer userId, Model model) {

        List<WorkoutLog> workoutLogs =
                workoutService.getUserWorkoutHistory(userId);
        //model passes data from controller to the HTML pages
        model.addAttribute("logs", workoutLogs);
        model.addAttribute("total", workoutLogs.size());
        //tells which page to display 
        return "history";
    }
}
