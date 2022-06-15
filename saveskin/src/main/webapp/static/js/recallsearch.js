document.addEventListener("DOMContentLoaded", () => {
  const recallsearch_btn = document.querySelector("button.recall_search");
  const recallsearch_input = document.querySelector("input.search1");
  const recallsearch_form = document.querySelector("form.searchform");

  if (recallsearch_btn) {
    recallsearch_btn.addEventListener("click", () => {
      if (recallsearch_input.value === "") {
        alert("검색어를 입력해주세요");
        recallsearch_input.focus();
        return false;
      }
      recallsearch_form.submit();
    });
  }
});
