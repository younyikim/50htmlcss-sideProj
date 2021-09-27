const panels = [...document.querySelectorAll(".panel")];

function removeActivePanel() {
    panels.map((panel) => panel.classList.remove("active"));
}

panels.map((panel) => {
    panel.addEventListener("click", () => {
        removeActivePanel();
        panel.classList.add("active");
    });
});
