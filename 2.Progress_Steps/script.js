const progress = document.querySelector(".progress");
const steps = [...document.querySelectorAll(".step")];
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

let totalStep = 4;
let currentStep = 1;
let percentage = [0, 33, 66, 99];

function moveNext() {
    currentStep++;

    steps[currentStep - 1].classList.add("active");

    progress.style.width = `${percentage[currentStep - 1]}%`;

    // 현재 단계가 2단계 이상인 경우, prev 버튼 비활성화 해제
    if (currentStep >= 2) {
        prevBtn.removeAttribute("disabled");
    }

    // 현재 단계가 4단계인 경우, next 버튼 비활성화
    if (currentStep >= 4) {
        nextBtn.setAttribute("disabled", "");
    }
}

function movePrev() {
    currentStep--;

    steps[currentStep].classList.remove("active");

    progress.style.width = `${percentage[currentStep - 1]}%`;

    // 현재 단계가 1단계일 때, prev 버튼을 비활성화
    if (currentStep <= 1) {
        prevBtn.setAttribute("disabled", "");
    }
    // 현재 단계가 3단계 이하일 경우, next 버튼 비활성화 제거
    if (currentStep <= 3) {
        nextBtn.removeAttribute("disabled");
    }
}

// Event Listener
prevBtn.addEventListener("click", movePrev);
nextBtn.addEventListener("click", moveNext);
