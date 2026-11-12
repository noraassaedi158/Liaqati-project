use liaqaty_db;
delete FROM liaqaty_db.exercises;

INSERT INTO Exercises
(exercise_name, description, equipment_type, reps, sets, rest)
VALUES

-- Shoulder
('Overhead Press',
'A fundamental exercise for building shoulder strength and size with a strong emphasis on the front muscles.',
'Dumbbells', 10, 4, '100–120 Seconds'),

('Upright Row',
'An exercise for targeting the lateral muscles and trapezius, helping to broaden the shoulders and strengthen the upper back.',
'Dumbbells', 10, 3, '60–90 Seconds'),

('Front Raise',
'An exercise that directly focuses on strengthening and defining the front shoulder muscle.',
'Dumbbells', 12, 3, '60–90 Seconds'),

-- Arms
('Barbell Curl',
'A fundamental exercise for building biceps size and strength, helping to increase arm muscle mass.',
'Barbell', 10, 3, '60 Seconds'),

('Tricep Pushdown',
'An exercise targeting the triceps, helping to define and strengthen the back of the arm.',
'Cable Machine', 10, 3, '60–100 Seconds'),

('Assisted Triceps Dip',
'A machine-assisted exercise to safely build triceps strength and size.',
'Assisted Dip Machine', 10, 3, '60–100 Seconds'),

-- Chest
('Incline Bench Press',
'An exercise targeting the upper chest to build mass and strength.',
'Incline Bench or Barbell', 12, 3, '80–120 Seconds'),

('Flat Bench Press',
'A fundamental exercise for building middle chest strength and size.',
'Flat Bench or Barbell', 12, 3, '80–120 Seconds'),

('Pec Deck',
'A machine-based exercise to build the inner chest muscle.',
'Pec Deck Machine', 12, 3, '60–90 Seconds'),

-- Core
('Plank',
'A stability exercise to strengthen the core and improve balance. Hold for 60 seconds.',
'None', NULL, 3, '50 Seconds'),

('Crunches',
'An exercise focusing on strengthening the upper abs.',
'None', 20, 2, '60 Seconds'),

('Hanging Leg Raises',
'An exercise targeting the lower abs and increasing core strength.',
'Pull-up Bar', 15, 2, '30 Seconds'),

-- Back
('Lat Pulldown',
'An exercise to widen the lats and build upper back strength.',
'Cable Machine', 10, 3, '60 Seconds'),

('Pull-Up',
'A fundamental exercise to build strength and width in the upper back muscles.',
'Pull-up Bar', 5, 3, '60 Seconds'),

('Barbell Row',
'An exercise to increase mid-back thickness and build muscle mass.',
'Barbell', 10, 2, '80–100 Seconds'),

-- Lower Body
('Squats',
'A fundamental exercise for building lower body strength and size.',
'Barbell - Dumbbells', 10, 3, '80–100 Seconds'),

('Leg Press',
'A machine-based exercise to build leg muscle strength.',
'Leg Press Machine', 12, 3, '100 Seconds'),

('Lunges',
'An exercise that enhances balance and targets the glutes and thighs.',
'Dumbbells - Bodyweight', 10, 1, '60 Seconds');

UPDATE Exercises SET
difficulty_level = 'Intermediate',
instructions = 'Stand with your feet shoulder-width apart. Hold dumbbells at shoulder level, press them overhead, then slowly lower them.'
WHERE exercise_name = 'Overhead Press';

UPDATE Exercises SET
difficulty_level = 'Intermediate',
instructions = 'Hold dumbbells in front of your thighs. Pull them upward toward your chest with your elbows pointing outward, then lower slowly.'
WHERE exercise_name = 'Upright Row';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Hold dumbbells at your sides. Raise your arms straight in front of you to shoulder height, then lower slowly.'
WHERE exercise_name = 'Front Raise';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Hold a barbell with your palms facing forward. Curl it toward your shoulders, then lower it slowly.'
WHERE exercise_name = 'Barbell Curl';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Stand facing the cable machine. Push the handle down until your arms are straight, then slowly return.'
WHERE exercise_name = 'Tricep Pushdown';

UPDATE Exercises SET
difficulty_level = 'Intermediate',
instructions = 'Use the assisted dip machine. Lower your body by bending your elbows, then push yourself back up.'
WHERE exercise_name = 'Assisted Triceps Dip';

UPDATE Exercises SET
difficulty_level = 'Intermediate',
instructions = 'Lie on an incline bench. Lower the barbell toward your upper chest, then press it upward.'
WHERE exercise_name = 'Incline Bench Press';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Lie on a flat bench. Lower the barbell toward your chest, then press it upward until your arms are extended.'
WHERE exercise_name = 'Flat Bench Press';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Sit on the pec deck machine. Bring the handles together in front of your chest, then slowly return.'
WHERE exercise_name = 'Pec Deck';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Place your forearms on the floor and keep your body straight. Hold the position for 60 seconds.'
WHERE exercise_name = 'Plank';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Lie on your back with your knees bent. Lift your shoulders toward your knees, then slowly lower them.'
WHERE exercise_name = 'Crunches';

UPDATE Exercises SET
difficulty_level = 'Advanced',
instructions = 'Hang from a pull-up bar. Raise your legs toward your chest, then slowly lower them without swinging.'
WHERE exercise_name = 'Hanging Leg Raises';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Sit at the cable machine and pull the bar down toward your upper chest. Slowly return it upward.'
WHERE exercise_name = 'Lat Pulldown';

UPDATE Exercises SET
difficulty_level = 'Advanced',
instructions = 'Hang from a pull-up bar with your hands shoulder-width apart. Pull your body upward until your chin reaches the bar, then lower slowly.'
WHERE exercise_name = 'Pull-Up';

UPDATE Exercises SET
difficulty_level = 'Intermediate',
instructions = 'Bend forward slightly while holding a barbell. Pull it toward your waist, then lower it slowly.'
WHERE exercise_name = 'Barbell Row';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Stand with your feet shoulder-width apart. Bend your knees and hips to lower your body, then push back up.'
WHERE exercise_name = 'Squats';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Sit on the leg press machine. Push the platform away by extending your legs, then slowly bend your knees.'
WHERE exercise_name = 'Leg Press';

UPDATE Exercises SET
difficulty_level = 'Beginner',
instructions = 'Stand upright and step forward with one leg. Bend both knees, then push back to the starting position. Repeat with the other leg.'
WHERE exercise_name = 'Lunges';

-- BC NUMBER START 1
SET @row_number = 0;

UPDATE Exercises
SET exercise_id = (@row_number := @row_number + 1)
ORDER BY exercise_id;

ALTER TABLE Exercises AUTO_INCREMENT = 1;