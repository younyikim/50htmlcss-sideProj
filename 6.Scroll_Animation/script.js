const boxElList = document.querySelectorAll(".box");
const container = document.querySelector(".container");
const sentinel = document.querySelector(".sentinel");

document.addEventListener("DOMContentLoaded", () => {
    let options = {
        root: null,
        rootMargin: "0px",
        threshold: 0.5,
    };

    function handleIntersection(entries, observer) {
        entries.forEach((entry) => {
            const currentIndex = Array.from(boxElList).indexOf(entry.target);
            console.log(currentIndex);
            if (entry.isIntersecting) {
                boxElList[currentIndex].classList.add("show");
            } else {
                boxElList[currentIndex].classList.remove("show");
            }
        });
    }

    let observer = new IntersectionObserver(handleIntersection, options);

    boxElList.forEach((el) => {
        observer.observe(el);
    });
});
