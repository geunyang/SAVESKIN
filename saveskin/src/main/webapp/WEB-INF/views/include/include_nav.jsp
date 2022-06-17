<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>




	<nav>
		<c:choose>
			<c:when test="${empty USER}">
				<div class="loginwrap">
					<ul class="login">
						<li><a href="${rootPath}/user/user_join">회원가입</a></li>
						<li><a href="${rootPath}/user/user_login">로그인</a></li>
						<li><a href="#"><i onclick="ShowBell()"
								class="fa-solid fa-bell"></i></a></li>
					</ul>
				</div>
			</c:when>
			<c:when test="${not empty USER}">
				<div class="loginwrap">
					<ul class="login">
						<li><a href="${rootPath}/user/user_join">회원가입</a></li>
						<li><a href="${rootPath}/user/user_logout">로그아웃</a></li>
						<li><a href="#"><i onclick="ShowBell()"
								class="fa-solid fa-bell"></i></a></li>
					</ul>
				</div>
			</c:when>
		</c:choose>
		<div id="bell-watch">
			<div id="bell-see">
				<a href="#"><i onclick="HideBell()" class="fa-solid fa-x"></i></a>
				<p>알림 확인 해라</p>

				<c:forEach items="${RECALLS}" var="RECALL" varStatus="INDEX">
					<div data-recallsn="${RECALL.recallSn}" class="bell-box">
						<a href="${rootPath}/recall/racall_detail">&lt;${INDEX.count}&gt;
							${RECALL.productNm}</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<ul id="menu">
			<li><a href="${rootPath}/" class="home"><img id="logo"
					name="home" src="${rootPath}/static/image/logo.png" /></a></li>

			<li><a href="${rootPath}/recall/recall_list">리콜정보</a></li>
			<li><a href="${rootPath}/info/info_list">화장품 심사정보</a></li>
			<li><a href="${rootPath}/board/board_list">커뮤니티</a></li>
			<li><a href="${rootPath}/myprofile/myprofile">마이페이지</a></li>
		</ul>
	</nav>
</header>
