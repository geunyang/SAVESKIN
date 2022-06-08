document.addEventListener("DOMContentLoaded", () => {
  const recall_list = document.querySelector("table.RECALLS");
  recall_list?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const recallSn = tr.dataset.recallSn;
      document.location.href = `${rootPath}/recall/${recallSn}/recall_detail`;
    }
  });
});
