const progress = document.querySelector(".progress");
const steps = document.querySelectorAll(".step");
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

let currentStep = 1;

function update() {
    steps.forEach((step, index) => {
        if (index < currentStep) {
            step.classList.add("active");
        } else {
            step.classList.remove("active");
        }
    });

    const actives = document.querySelectorAll(".active");

    progress.style.width =
        ((actives.length - 1) / (steps.length - 1)) * 100 + "%";

    if (currentStep == 1) {
        prevBtn.disabled = true;
    } else if (currentStep == steps.length) {
        nextBtn.disabled = true;
    } else {
        prevBtn.disabled = false;
        nextBtn.disabled = false;
    }
}

// Event Listener
nextBtn.addEventListener("click", () => {
    currentStep++;

    if (currentStep > steps.length) {
        currentStep = steps.length;
    }

    update();
});

prevBtn.addEventListener("click", () => {
    currentStep--;

    if (currentStep < 1) {
        currentStep = 1;
    }

    update();
});
