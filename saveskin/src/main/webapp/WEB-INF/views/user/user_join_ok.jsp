<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
</head>
<style>
section {
	flex: 1;
}

article{
	width:25%;
	text-align: center;
	margin:240px auto 0;
}

article img{
	width: 100%;
}

section article h1{
	margin:30px 0 2px;;
	font-size:20px;
}

section article p{
	border-bottom: 1px solid rgb(34,34,34);
	margin-bottom: 30px;
}

section article a{
	border: 1px solid rgb(118, 201, 65);
	padding:10px 16px;
	text-decoration: none;
	color: rgb(34,34,34);
	border-radius: 8px;
	font-size: 14px;
}

section article a:hover{
	font-weight: 900;
	text-decoration: underline;
	background-color: rgb(118, 201, 65);
	color: #fff;
}
</style>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>

	<section>
		<article>
			<img src="${rootPath}/static/image/logo.png">
			<h1>가입을 환영합니다!</h1>
			<p>피부를 지키는 알리미 SAVE SKIN의 정보를 받아보세요!</p>
			
			<a href="${rootPath}/">메인으로 가기</a>
			<a href="${rootPath}/user/user_login">로그인 하러가기</a>
		</article>
	</section>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>