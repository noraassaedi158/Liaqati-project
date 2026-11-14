
document.getElementById("calorieForm").addEventListener("submit", async function(event) {
    event.preventDefault();

    const age = Number(document.getElementById("age").value);
    const gender = document.getElementById("gender").value;
    const weight = Number(document.getElementById("weight").value);
    const height = Number(document.getElementById("height").value);
    const activityLevel = Number(document.getElementById("activity").value);

    const result = document.getElementById("calorieResult");

    if (!age || !gender || !weight || !height || !activityLevel ||
        age <= 0 || weight <= 0 || height <= 0) {
        result.textContent = "Please enter valid information.";
        return;
    }

    const data = {
        age: age,
        gender: gender,
        weight: weight,
        height: height,
        activityLevel: activityLevel
    };

    result.textContent = "Calculating...";

    try {
        const response = await fetch("/api/calories/calculate", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        const responseData = await response.json();

        if (!response.ok) {
            result.textContent = responseData.message || "Unable to calculate.";
            return;
        }

        result.textContent =
            "Estimated daily calories: " +
            responseData.estimatedCalories + " kcal";

    } catch (error) {
        result.textContent = "Connection error. Please try again.";
        console.error(error);
    }
});

document.getElementById("calorieForm").addEventListener("reset", function() {
    document.getElementById("calorieResult").textContent = "";
});
