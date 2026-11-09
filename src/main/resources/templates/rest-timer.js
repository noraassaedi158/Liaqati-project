
let restSeconds = 0;
let restInterval = null;

function updateRestDisplay() {
    let minutes = Math.floor(restSeconds / 60);
    let seconds = restSeconds % 60;

    document.getElementById("restDisplay").textContent =
        String(minutes).padStart(2, "0") + ":" +
        String(seconds).padStart(2, "0");
}

document.getElementById("restStart").addEventListener("click", function() {

    if (restInterval !== null) return;

    if (restSeconds <= 0) {
        let minutes = Number(document.getElementById("restMinutes").value);

        if (!Number.isInteger(minutes) || minutes <= 0) {
            alert("Please enter a valid number of minutes.");
            return;
        }

        restSeconds = minutes * 60;
        updateRestDisplay();
    }

    restInterval = setInterval(function() {
        if (restSeconds > 0) {
            restSeconds--;
            updateRestDisplay();
        } else {
            clearInterval(restInterval);
            restInterval = null;
            alert("Rest time is over!");
        }
    }, 1000);
});

document.getElementById("restPause").addEventListener("click", function() {
    clearInterval(restInterval);
    restInterval = null;
});

document.getElementById("restReset").addEventListener("click", function() {
    clearInterval(restInterval);
    restInterval = null;
    restSeconds = 0;

    document.getElementById("restMinutes").value = "";
    updateRestDisplay();
});
