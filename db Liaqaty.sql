CREATE DATABASE IF NOT EXISTS liaqaty_db
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

USE liaqaty_db;

-- 1. Users
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    age INT,
    weight DECIMAL(5,2),
    height DECIMAL(5,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Exercises
CREATE TABLE exercises (
    exercise_id INT AUTO_INCREMENT PRIMARY KEY,
    exercise_name VARCHAR(150) NOT NULL,
    description TEXT,
    equipment_type VARCHAR(100),
    difficulty_level VARCHAR(30),
    instructions TEXT
);

-- 3. Workouts
CREATE TABLE workouts (
    workout_id INT AUTO_INCREMENT PRIMARY KEY,
    workout_name VARCHAR(150) NOT NULL,
    workout_type VARCHAR(100),
    duration INT,
    difficulty_level VARCHAR(30)
);

-- 4. Workout Exercises
CREATE TABLE workout_exercises (
    workout_id INT NOT NULL,
    exercise_id INT NOT NULL,

    PRIMARY KEY (workout_id, exercise_id),

    FOREIGN KEY (workout_id)
        REFERENCES workouts(workout_id)
        ON DELETE CASCADE,

    FOREIGN KEY (exercise_id)
        REFERENCES exercises(exercise_id)
        ON DELETE CASCADE
);

-- 5. Workout Logs
CREATE TABLE workout_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    workout_id INT NOT NULL,
    completion_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    duration_minutes INT NOT NULL,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (workout_id)
        REFERENCES workouts(workout_id)
        ON DELETE RESTRICT,

    CHECK (duration_minutes > 0),

    INDEX idx_user_date (user_id, completion_date)
);

-- 6. Achievements
CREATE TABLE achievements (
    achievement_id INT AUTO_INCREMENT PRIMARY KEY,
    achievement_code VARCHAR(50) NOT NULL UNIQUE,
    achievement_name VARCHAR(100) NOT NULL,
    description TEXT,
    icon VARCHAR(255),
    points INT NOT NULL DEFAULT 20
);

-- 7. User Achievements
CREATE TABLE user_achievements (
    user_id INT NOT NULL,
    achievement_id INT NOT NULL,
    times_earned INT NOT NULL DEFAULT 0,
    total_points INT NOT NULL DEFAULT 0,
    first_earned_at DATETIME,
    last_earned_at DATETIME,

    PRIMARY KEY (user_id, achievement_id),

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (achievement_id)
        REFERENCES achievements(achievement_id)
        ON DELETE CASCADE
);

-- 8. Achievement Awards
CREATE TABLE achievement_awards (
    award_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    achievement_id INT NOT NULL,
    milestone_value INT NOT NULL DEFAULT 0,
    event_key VARCHAR(100) NOT NULL,
    earned_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    FOREIGN KEY (achievement_id)
        REFERENCES achievements(achievement_id)
        ON DELETE CASCADE,

    UNIQUE (user_id, achievement_id, event_key)
);

-- Insert Achievements
INSERT INTO achievements
(achievement_code, achievement_name, description, icon, points)
VALUES
('JOIN', 'Join Badge', 'Welcome to Liaqaty!', 'join.png', 20),

('BEGINNER', 'New Beginner','Complete every 3 consecutive workout days.','beginner.png', 20),

('GOING_STRONG', 'Going Strong','Complete every 10 consecutive workout days.','strong.png', 20),

('HAPPY_PROGRESS', 'Happy Progress','Reach your first 40 workout minutes.','progress.png', 20),

('MILESTONE', 'Milestone','Earn a badge for every additional 40 workout minutes.', 'milestone.png', 20);
