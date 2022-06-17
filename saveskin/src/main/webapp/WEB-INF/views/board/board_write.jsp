<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/board_write.css?ver=2022-06-15-001">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>

	<section id="b_write">
		<form method="POST" class="b_writeform">
			<div id="bw_title">
				<input name="b_num" type="hidden" value="${board.b_num}"/>
				<input name="b_title" type="text" placeholder="제목을 입력해주세요"	value="${board.b_title}" />
				<input name="b_writer"  value="${board.b_writer}" readonly="readonly"  hidden="hidden" />
				<input name="b_date" type="date" value="${board.b_date}" hidden="hidden">
				<input name="b_time" type="time" value="${board.b_time}" hidden="hidden">	
			</div>
			<div id="content">
				<textarea rows="50" name="b_content" class="" placeholder="내용을 입력해주세요"	>${board.b_content}</textarea>
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