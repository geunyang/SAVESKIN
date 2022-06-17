<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/board_detail.css?ver=2022-06-15-001">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/board_update.js?ver=2022-06-14-002"></script>	

</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>

	<section id="board-in">

		<div id="title1">

			<div id="nick">
				<img src="${rootPath}/static/image/01.png" />
				<p>닉네임</p>
			</div>

			<!-- 제목 title  -->

			<h3>${BOARD.b_title}</h3>
		</div>

		<!-- 내용 content -->
		<div id="content">
			<textarea>${BOARD.b_content}</textarea>
		</div>
			<c:if test="${USER1 eq 'OK'}">
				<div class="btn-box">
					<a onclick="history.back()" class="list">리스트</a> 
					<div class="update_btn">
					<a href="${rootPath}/board/${BOARD.b_num}/board_update" class="update">수정</a>
					</div>
					<!-- href="javascript:void(0) : a tag의 link 연결기능을 완전히 무력화 -->
					<a href="${rootPath}/board/${BOARD.b_num}/board_delete" class="delete">삭제</a>
				</div>
			</c:if>


		<!-- 댓글 부분 -->

		<div id="comment">
			<ul>
				<li>
					<div id="nick">
						<img src="${rootPath}/static/image/02.png" />
						<p>닉네임</p>
					</div>
					<p>카카오페이가</p>
				</li>
				<li>
					<div id="nick">
						<img src="${rootPath}/static/image/03.png" />
						<p>닉네임</p>
					</div>
					<p>SK하이닉스</p>
				</li>
			</ul>
		</div>

		<div id="comment-sub">
			<ul>
				<li id="comment-nick">닉네임님</li>
				<li><input type="text" placeholder="댓글을 남겨보세요!" /></li>
				<li id="btnli">
					<button type="button">댓글 등록</button>
				</li>
			</ul>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>