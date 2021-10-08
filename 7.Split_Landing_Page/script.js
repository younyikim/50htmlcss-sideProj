const pages = document.querySelector(".pages");
const left = document.querySelector(".page__left");
const right = document.querySelector(".page__right");

left.addEventListener("mouseenter", () => {
    pages.classList.add("hover-left");
});

left.addEventListener("mouseleave", () => {
    pages.classList.remove("hover-left");
});

right.addEventListener("mouseenter", () => {
    pages.classList.add("hover-right");
});

right.addEventListener("mouseleave", () => {
    pages.classList.remove("hover-right");
});
