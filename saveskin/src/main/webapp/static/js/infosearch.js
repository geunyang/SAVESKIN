document.addEventListener("DOMContentLoaded", () => {
  const infosearch_btn = document.querySelector("button.info_search");
  const infosearch_input = document.querySelector("input.search1");
  const infosearch_form = document.querySelector("input.searchform");

  if (infosearch_btn) {
    infosearch_btn.addEventListener("click", () => {
      if (infosearch_input.value === "") {
        alert("검색어를 입력해주세요");
        infosearch_input.focus();
        return false;
      }
      infosearch_form.submit();
    });
  }
});
