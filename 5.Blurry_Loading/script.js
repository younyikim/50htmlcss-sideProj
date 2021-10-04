const loadingText = document.querySelector(".loading__text");
const bg = document.querySelector(".bg");

let load = 0;

let int = setInterval(blurring, 30);

function blurring() {
    load++;

    if (load > 99) {
        clearInterval(int);
    }

    loadingText.innerText = `${load}%`;
    loadingText.style.opacity = scale(load, 0, 100, 1, 0);
    bg.style.filter = `blur(${scale(load, 0, 100, 30, 0)}px)`;
}

// https://stackoverflow.com/questions/10756313/javascript-jquery-map-a-range-of-numbers-to-another-range-of-numbers
const scale = (num, in_min, in_max, out_min, out_max) => {
    return ((num - in_min) * (out_max - out_min)) / (in_max - in_min) + out_min;
};

/*
 * ex) 10% load가 되었을 때, scale(10, 0, 100, 1, 0)을 계산하면, ((10 - 0) * (0 - 1)) / (100 - 0) + 1 = 1 - 10/100 = 1 - 1/10 = 9/10 = 0.9
 * 즉 scale = 0.9가 된다. loadingText.style.opacity = 0.9가 되는 것이다. 50%가 load 되었다면, scale = 0.5가 되기 때문에 opacity = 0.5가 된다.
 *
 * opacity 뿐만 아니라, bg의 filter의 blur 도 이 계산식을 통해 지정할 수 있다.
 * 예를 들어 load가 10% 되었을 땐, blur(27px)이고 90% 되었을 땐 blur(3px)으로 계산된다.
 */
