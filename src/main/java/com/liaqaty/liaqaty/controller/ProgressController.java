
package com.liaqaty.liaqaty.controller;

import org.springframework.web.bind.annotation.*;

import com.liaqaty.liaqaty.DTO.ProgressDTO;
import com.liaqaty.liaqaty.service.ProgressService;

@RestController  //serialization for Json so JS can get the data
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }
    //DTO class will get all info in a big chunk and this class will turn that into JSON
    @GetMapping("/{userId}")
    public ProgressDTO getUserProgress(
            @PathVariable Integer userId) {
        return progressService.getUserProgress(userId);
    }
}
