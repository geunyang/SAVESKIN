document.addEventListener("DOMContentLoaded", () => {
  const open = document.querySelector("button.oBtn");

  open.addEventListener("click", () => {
    document.querySelector("div.add").style.opacity = 1;
    open.style.opacity = 0;
  });

  const close = document.querySelector("button.cBtn");

  close.addEventListener("click", () => {
    document.querySelector("div.add").style.opacity = 0;
    open.style.opacity = 1;
  });
});
