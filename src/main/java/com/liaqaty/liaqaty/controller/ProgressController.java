@Controller
@RequestMapping("/progress")
public class progressController {

    private final ProgressService progressService;

    public progressController(ProgressService progressService) {
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
