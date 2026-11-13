package com.liaqaty.liaqaty.controller;

import org.springframework.web.bind.annotation.*;

import com.liaqaty.liaqaty.DTO.ProgressDTO;
import com.liaqaty.liaqaty.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{userId}")
    public ProgressDTO getUserProgress(
            @PathVariable Integer userId) {

        return progressService.getUserProgress(userId);
    }
}
