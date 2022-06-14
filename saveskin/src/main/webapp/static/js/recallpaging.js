document.addEventListener("DOMContentLoaded", () => {
  const recall_paging = document.querySelector("li.paging");
  recall_paging?.addEventListener("click", (e) => {
    // console.log("테이블 클릭했음");
    const li = e.target;
    if (li.tagName === "LI") {
      const recallSn = tr.dataset.recallsn;
      document.location.href = `${rootPath}/recall/${recallSn}/recall_detail`;
    }
  });
});
