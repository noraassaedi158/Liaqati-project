USE liaqaty_db;

-- التمارين
INSERT INTO exercises
(exercise_name, description, equipment_type, difficulty_level, instructions)
VALUES
('Squats', 'Strengthens leg muscles.', 'No Equipment', 'Beginner', 'Stand with feet apart, bend your knees, then return to standing.'),
('Push-ups', 'Strengthens chest and arms.', 'No Equipment', 'Beginner', 'Lower your body toward the floor and push back up.'),
('Plank', 'Strengthens core muscles.', 'No Equipment', 'Beginner', 'Hold your body straight using your forearms and toes.'),
('Lunges', 'Improves leg strength and balance.', 'No Equipment', 'Beginner', 'Step forward and bend both knees, then return.'),
('Jumping Jacks', 'Improves cardiovascular fitness.', 'No Equipment', 'Beginner', 'Jump while opening your arms and legs, then close them.'),
('Dumbbell Curls', 'Strengthens arm muscles.', 'Dumbbells', 'Intermediate', 'Lift dumbbells toward your shoulders and lower slowly.');

-- الخطط الرياضية
INSERT INTO workouts
(workout_name, workout_type, duration, difficulty_level)
VALUES
('Beginner Full Body', 'Full Body', 20, 'Beginner'),
('Home Cardio', 'Cardio', 15, 'Beginner'),
('Upper Body Workout', 'Strength', 25, 'Intermediate');

-- ربط التمارين بالخطط
INSERT INTO workout_exercises (workout_id, exercise_id)
VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(2, 5),
(2, 1),
(3, 2),
(3, 6);
