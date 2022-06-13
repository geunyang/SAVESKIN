document.addEventListener("DOMContentLoaded", () => {
  const name_check = document.querySelector("button.name-check");
  const update_btn = document.querySelector("button.user_update");
  const join_form = document.querySelector("form.user_join");

  const index = {
    username: 0,
    password: 1,
    re_password: 2,
    email: 3,
  };

  //form.join 내부에 있는 모든 input box
  //SelectAll을 사용하면 tag요소를 배열로 가져온다
  const inputList = document.querySelectorAll("form.user_update input");

  //inputList 0번 요소 부터 4번 요소까지
  //form tag 에 작성된 순서대로 담겨있다.
  //index 객체에서 각 요소의 첨자를 가져오고 첨자를 사용하여 input tag를 각 순서대로 변수에 담겠다.
  const username = inputList[index.username];
  const password = inputList[index.password];
  const re_password = inputList[index.re_password];
  const email = inputList[index.email];

  // 중복검사 text 입력칸 변수 선언
  const username_msg = document.querySelector("div.username-text");
  const pw_msg = document.querySelector("div.pw-text");
  const repw_msg = document.querySelector("div.repw-text");





  // name input이 공백일때
  const username_isBlank = () => {
    username_msg.innerText = "NICK NAME을 입력해 주세요";
    username.focus();
    return false;
  };


  //join btn 클릭
  if (update_btn) {
    update_btn.addEventListener("click", () => {
 
      if (username.value === "") {
        username_isBlank();
        return false;
      }
      if (password.value === "") {
        pw_msg.innerText = "비밀번호를 입력해주세요";
        password.focus();
        return false;
      }
      if (re_password.value === "") {
        repw_msg.innerText = "비밀번호 확인을 입력해 주세요";
        re_password.focus();
        return false;
      }
      if (password.value !== re_password.value) {
        repw_msg.innerText = "비밀번호 확인 값이 서로 달라요";
        password.value = "";
        re_password.value = "";
        password.focus();
        return false;
      }

      update_btn.submit();
    });
  }


   //name 중복검사 클릭
  if (name_check) {
    name_check.addEventListener("click", () => {
      if (username.value === "") {
        username_isBlank();
        return false;
      } //end if

      fetch(`${rootPath}/myprofile/namecheck/${username.value}`)
        .then((res) => {
          //console.table(index);
         //console.table(res);
          return res.text();
        })
        .then((result) => {
          if (result === "OK") {
             username_msg.innerText = " 사용가능한 NAME 입니다.";
          } else {
            username_msg.innerText = " 이미 가입된 NAME 입니다";
          }
        });

    });
  }
});
