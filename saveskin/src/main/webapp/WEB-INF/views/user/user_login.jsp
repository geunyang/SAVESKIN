<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp" %>
<link rel="stylesheet" href="${rootPath}/static/css/login.css?ver=2022-06-05-1">
</head>
<body>
<%@ include file="/WEB-INF/views/include/include_nav.jsp" %>
<section>
      <div class="mainbox">
        <div class="line">
          <h1>로그인</h1>
        </div>
        <article class="input-login">
          <form method="POST" autocomplete="off">
            <fieldset>
              <div class="infoinput">
                <i class="fa-solid fa-user"></i>
                <input type="text" name="userid"placeholder="아이디를 입력해주세요" />
              </div>
              <div class="infoinput">
                <i class="fa-solid fa-lock"></i>
                <input type="text" name="password" placeholder="비밀번호를 입력해주세요" />
              </div>
              <div class="btnbox">
                <button class="btn" id="loginalertStart">
                  로그인
                </button>
              </div>
            </fieldset>
          </form>
          <div class="gotojoin">
            <p>
              계정이 없으신가요? &gt;
              <a href="${rootPath}/user/user_join">회원가입</a> 하러가기
            </p>
          </div>
          <div class="login_info">
		
	
	
		
	</div>
        </article>
      </div>
</section>


<%@ include file="/WEB-INF/views/include/include_footer.jsp" %>
</body>
</html>