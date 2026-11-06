package com.Liaqati.practice;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrackerController {

    // Dummy workout names. Later these come from the database.
    private List<String> workoutNames() {
        return List.of("Full Body Home Workout", "Gym Upper Body", "Short Stretch Routine");
    }

    // ---------- DIARY ----------

    @GetMapping("/diary")
    public String diary(Model model) {
        model.addAttribute("workouts", workoutNames());
        return "diary";
    }

    @PostMapping("/diary")
    public String saveDiary(
            @RequestParam String workout,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time,
            @RequestParam int minutes,
            Model model) {

        // Server-side validation (the browser checks are not enough)
        String error = null;
        if (!workoutNames().contains(workout)) {
            error = "Please choose a valid workout.";
        } else if (date.isAfter(LocalDate.now())) {
            error = "The date cannot be in the future.";
        } else if (minutes < 1 || minutes > 300) {
            error = "Duration must be between 1 and 300 minutes.";
        }

        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("workouts", workoutNames());
            return "diary"; // show the form again with the message
        }

        // For now just print it. In Sprint 2 this becomes a database save.
        System.out.println("Logged: " + workout + " on " + date + " at " + time
                + " for " + minutes + " min");

        return "redirect:/history"; // send the user to the history page
    }

    // ---------- HISTORY & PROGRESS ----------

    @GetMapping("/history")
    public String history(Model model) {
        List<WorkoutLogView> logs = List.of(
            new WorkoutLogView("2026-11-01", "Full Body Home Workout", 20),
            new WorkoutLogView("2026-11-03", "Gym Upper Body", 40),
            new WorkoutLogView("2026-11-05", "Short Stretch Routine", 10)
        );
        model.addAttribute("logs", logs);
        model.addAttribute("total", logs.size());
        return "history";
    }

    // ---------- BADGES ----------
 // ---------- PROGRESS ----------

    @GetMapping("/progress")
    public String progress(Model model) {

        List<WorkoutLogView> logs = List.of(
            new WorkoutLogView("2026-11-02", "Full Body Workout", 15),
            new WorkoutLogView("2026-11-03", "Stretch Routine", 20),
            new WorkoutLogView("2026-11-04", "Upper Body", 15),
            new WorkoutLogView("2026-11-05", "Lower Body", 20),
            new WorkoutLogView("2026-11-06", "Full Body Workout", 25)
        );

        List<ProgressBadgeView> badges = List.of(
            new ProgressBadgeView(
                "Join Badge", "Awarded upon registration", "🏅", 1, false
            ),
            new ProgressBadgeView(
                "New Beginner", "Every 3 consecutive workout days", "🌱", 2, true
            ),
            new ProgressBadgeView(
                "Going Strong", "Every 10 consecutive workout days", "🔥", 0, true
            ),
            new ProgressBadgeView(
                "Happy Progress", "First 40 workout minutes", "🌟", 1, false
            ),
            new ProgressBadgeView(
                "Milestone", "Every additional 40 workout minutes", "🏆", 1, true
            )
        );

        int totalMinutes = logs.stream()
            .mapToInt(WorkoutLogView::minutes)
            .sum();

        int totalPoints = badges.stream()
            .mapToInt(b -> b.timesEarned() * 20)
            .sum();

        int earnedBadges = badges.stream()
            .mapToInt(ProgressBadgeView::timesEarned)
            .sum();

        int remainingMinutes = 40 - (totalMinutes % 40);

        int milestoneProgress = (int) Math.round(
            (totalMinutes % 40) / 40.0 * 100
        );

        model.addAttribute("logs", logs);
        model.addAttribute("badges", badges);
        model.addAttribute("totalMinutes", totalMinutes);
        model.addAttribute("totalPoints", totalPoints);
        model.addAttribute("earnedBadges", earnedBadges);
        model.addAttribute("currentStreak", 5);
        model.addAttribute("remainingMinutes", remainingMinutes);
        model.addAttribute("milestoneProgress", milestoneProgress);

        return "progress";
    }
    @GetMapping("/badges")
    public String badges(Model model) {
        List<BadgeView> badges = List.of(
            new BadgeView("First Step", "Complete 1 workout", true),
            new BadgeView("Getting Consistent", "Complete 5 workouts", false),
            new BadgeView("Dedicated", "Complete 20 workouts", false),
            new BadgeView("Streak Starter", "Work out 3 days in a row", false)
        );
        model.addAttribute("badges", badges);
        return "badges";
    } }
    
record WorkoutLogView(String date, String workoutName, int minutes) {}
record BadgeView(String name, String description, boolean earned) {}
record ProgressBadgeView(
	    String name,
	    String description,
	    String icon,
	    int timesEarned,
	    boolean repeatable
	) {}
