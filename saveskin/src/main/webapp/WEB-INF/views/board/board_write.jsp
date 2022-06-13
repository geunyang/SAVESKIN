<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/board_write.css?ver=2022-06-113-001">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>

	<section>
		<form method="POST" class="">
			<div id="title">
				<c:if test="${not empty board.b_num }">
			readonly="readonly"
		</c:if>
				<input name="b_title" type="text" placeholder="제목을 입력해주세요"
					value="${board.b_title}" />
			</div>
			<div id="content">
				<textarea rows="50" name="b_content" class="">${board.b_content}</textarea>
				<%-- <input name="b_content" type="text" placeholder="내용을 입력해주세요"
					value="${board.b_content}" /> --%>
			</div>
			<div id="btn">
				<button type="submit">게시글 등록</button>
			</div>
		</form>
	</section>


	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>