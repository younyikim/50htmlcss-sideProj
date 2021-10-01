const searchBtn = document.getElementById("search-btn");
const searchContainer = document.querySelector(".search-container");

searchBtn.addEventListener("click", () => {
    searchContainer.classList.toggle("active");
});
