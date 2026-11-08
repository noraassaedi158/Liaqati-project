
package com.liaqaty.liaqaty.repository;

import com.liaqaty.liaqaty.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Integer> {

    List<WorkoutLog> findByUser_UserIdOrderByCompletionDateDesc(Integer userId);
}
