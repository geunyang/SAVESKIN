document.addEventListener("DOMContentLoaded", () => {
  const info_list = document.querySelector("table.INFOS");
  info_list?.addEventListener("click", (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const ENTP_SEQ = tr.dataset.entp_seq;
      //     console.log("테이블 클릭했음");
      document.location.href = `${rootPath}/info/${ENTP_SEQ}/info_detail`;
    }
  });
});
