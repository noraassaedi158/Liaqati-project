
package com.liaqaty.liaqaty.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.service.ProgressService;

@Controller
@RequestMapping("/progress")
public class ProgressPageController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{userId}")
    public String showProgress(@PathVariable Integer userId, Model model) {

        List<WorkoutLog> logs = progressService.getUserLogs(userId);

        model.addAttribute("logs", logs);
        model.addAttribute("totalMinutes",
                progressService.getTotalMinutes(userId));

        model.addAttribute("remainingMinutes",
                progressService.getRemainingMinutes(userId));

        model.addAttribute("milestoneProgress",
                progressService.getMilestoneProgress(userId));

        model.addAttribute("currentStreak",
                progressService.getCurrentStreak(userId));

        // Temporary values until badge implementation is integrated
        model.addAttribute("totalPoints", 0);
        model.addAttribute("earnedBadges", 0);
        model.addAttribute("badges", List.of());

        return "progress";
    }
}
