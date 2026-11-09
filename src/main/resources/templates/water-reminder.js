
let waterSeconds = 0;
let waterInterval = null;

function updateWaterDisplay() {
    let minutes = Math.floor(waterSeconds / 60);
    let seconds = waterSeconds % 60;

    document.getElementById("waterDisplay").textContent =
        String(minutes).padStart(2, "0") + ":" +
        String(seconds).padStart(2, "0");
}

document.getElementById("waterStart").addEventListener("click", function() {

    if (waterInterval !== null) return;

    if (waterSeconds <= 0) {
        let minutes = Number(document.getElementById("waterMinutes").value);

        if (!Number.isInteger(minutes) || minutes <= 0) {
            alert("Please enter a valid number of minutes.");
            return;
        }

        waterSeconds = minutes * 60;
        updateWaterDisplay();
    }

    waterInterval = setInterval(function() {
        if (waterSeconds > 0) {
            waterSeconds--;
            updateWaterDisplay();
        } else {
            clearInterval(waterInterval);
            waterInterval = null;
            alert("Time to drink water!");
        }
    }, 1000);
});

document.getElementById("waterPause").addEventListener("click", function() {
    clearInterval(waterInterval);
    waterInterval = null;
});

document.getElementById("waterReset").addEventListener("click", function() {
    clearInterval(waterInterval);
    waterInterval = null;
    waterSeconds = 0;

    document.getElementById("waterMinutes").value = "";
    updateWaterDisplay();
});
