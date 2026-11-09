
document.getElementById("calorieForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let age = Number(document.getElementById("age").value);
    let gender = document.getElementById("gender").value;
    let weight = Number(document.getElementById("weight").value);
    let height = Number(document.getElementById("height").value);
    let activity = Number(document.getElementById("activity").value);

    if (!age || !weight || !height || age <= 0 || weight <= 0 || height <= 0) {
        document.getElementById("calorieResult").textContent =
            "Please enter valid information.";
        return;
    }

    let bmr;

    if (gender === "male") {
        bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
    } else {
        bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
    }

    let calories = Math.round(bmr * activity);

    document.getElementById("calorieResult").textContent =
        "Estimated daily calories: " + calories + " kcal";
});

document.getElementById("calorieForm").addEventListener("reset", function() {
    document.getElementById("calorieResult").textContent = "";
});
