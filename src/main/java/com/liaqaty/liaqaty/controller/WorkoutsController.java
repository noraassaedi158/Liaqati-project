package com.liaqaty.liaqaty.controller;
import com.liaqaty.liaqaty.entity.Workout;
import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.service.WorkoutService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*this is our workoutController, its main goal is to receive requests from the front end and then pass it our Services/Workout Services
where the work happens */

@RestController    //Combination of Response body and controller, and turns java objects into JSON
@RequestMapping("/api/workouts")   //RequestMapping is for the common URL in all our pages
public class WorkoutsController {

    private final WorkoutService workoutService;

    //Controller needs to our service part of the program to do its job 
    //instead of making an object out of workoutService were asking Spring to make one, we used Constructor injecting
    public WorkoutsController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    //When GET is used in this URL get the list of all workouts because we want to retrieve all workouts
    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    //Get user's workout history with the place holder, cause each user has its own history
    @GetMapping("/history/{userId}")
    public List<WorkoutLog> getUserWorkoutHistory(
    		// path variable means part of the URL is dynamic--the id part. its takes it from the URL
            @PathVariable Integer userId) {
    	
        return workoutService.getUserWorkoutHistory(userId);
    }

    
}


