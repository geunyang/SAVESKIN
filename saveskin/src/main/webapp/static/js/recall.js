document.addEventListener("DOMContentLoaded", () => {
  const recall_list = document.querySelector("table.RECALLS");
  recall_list?.addEventListener("click", (e) => {
    // console.log("테이블 클릭했음");
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const recallSn = tr.dataset.recallsn;
      document.location.href = `${rootPath}/recall/${recallSn}/recall_detail`;
    }
  });
});
