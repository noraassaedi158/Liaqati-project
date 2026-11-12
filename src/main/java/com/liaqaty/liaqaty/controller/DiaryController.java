
package com.liaqaty.liaqaty.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liaqaty.liaqaty.entity.WorkoutLog;
import com.liaqaty.liaqaty.service.WorkoutService;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    private final WorkoutService workoutService;

    public DiaryController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

   
    //when a post request happens, execute this and save a workout log
    @PostMapping
    public WorkoutLog saveWorkoutLog(
    		//extract the data from the post request and store it here
    		@RequestParam Integer userId,
            @RequestParam Integer workoutId,
            @RequestParam Integer durationMinutes,
            @RequestParam LocalDate date,
            @RequestParam LocalTime time) {
        //then save it in  services
    	LocalDateTime completionDate = LocalDateTime.of(date, time);
        return workoutService.saveWorkoutLog( userId,
                 workoutId,
                 durationMinutes,
                completionDate);
        
        
    }
}
