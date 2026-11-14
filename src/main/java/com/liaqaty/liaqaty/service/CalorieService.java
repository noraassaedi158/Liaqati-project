
package com.liaqaty.liaqaty.service;

import org.springframework.stereotype.Service;

import com.liaqaty.liaqaty.DTO.CalorieDTO;

@Service
public class CalorieService {

    public CalorieDTO calculateCalories(CalorieDTO data) {

        if (data.getAge() < 18 ||
            data.getWeight() <= 0 ||
            data.getHeight() <= 0 ||
            data.getActivityLevel() <= 0) {

            throw new IllegalArgumentException(
                "Invalid information. This estimate is intended for adults."
            );
        }

        double bmr;

        if ("male".equalsIgnoreCase(data.getGender())) {

            bmr = (10 * data.getWeight())
                    + (6.25 * data.getHeight())
                    - (5 * data.getAge()) + 5;

        } else if ("female".equalsIgnoreCase(data.getGender())) {

            bmr = (10 * data.getWeight())
                    + (6.25 * data.getHeight())
                    - (5 * data.getAge()) - 161;

        } else {
            throw new IllegalArgumentException("Invalid gender.");
        }

        double calories = bmr * data.getActivityLevel();

        data.setEstimatedCalories(Math.round(calories));

        return data;
    }
}
