<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>

<link rel="stylesheet" href="${rootPath}/static/css/join.css?ver=2022-06-12-001">
<script>
	const rootPath = "${rootPath}"
</script>

</head>
<body>
<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
<section>
      <div class="mainbox">
        <div class="line">
          <h1>회원정보 수정</h1>
        </div>
        <article class="join">
          <form class="user_update" method="POST" autocomplete="off">
            <fieldset>
         
              <div>
                <label>닉네임 변경</label>

                <input type="text" name="username" placeholder="닉네임를 입력해주세요" autocomplete="none"/>
                <button type="button" class="name-check" id="checknickalertStart">
                  중복확인
                </button>
                <div class="username-text"></div>
              </div>
              <div>
                <label>비밀번호 변경</label>
                <input type="password"  name="password" autocomplete="none" placeholder="비밀번호를 입력해주세요"/>
              <div class="pw-text"></div>
              </div>
              <div>
                <label>비밀번호 변경확인</label>
                <input type="password" name="re_password" autocomplete="none" placeholder="비밀번호를 확인해주세요"/>
              <div class="repw-text"></div>
              </div>
              <div>
                <label>이메일 변경</label>
                <input type="text" name="email" placeholder="이메일을 입려해주세요" autocomplete="none"/>@
                <select>
                  <option selected value="callor.com">callor.com</option>
                  <option value="naver.com">naver.com</option>
                  <option value="gmail.com">gmail.com</option>
                  <option value="daum.net">daum.net</option>
                  <option>직접입력</option>
                </select>
              </div>
              <div class="btnbox">
                <button type="button" class="btn user-update" id="alertStart">
                  저장
                </button>
              </div>
            </fieldset>
          </form>
          
        </article>
      </div>
    </section>


<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
<script src="${rootPath}/static/js/user-update.js?ver=2022-06-12-008">
</script>
</body>
</html>