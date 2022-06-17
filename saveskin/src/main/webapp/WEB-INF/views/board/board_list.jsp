<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/board_list.css?ver=2022-05-28-001">
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/board.js?ver=2022-06-10-002"></script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section id="freeboard">
		<div id="topsection">
			<div id="bh2">
				<ul>
					<li>
						<h2>커뮤니티 자유게시판</h2>

					</li>
				</ul>
			</div>
			<div id="bp">
				<p>화장품에 대한 정보를 자유롭게!</p>
			</div>
		</div>

		<table id="boardtable" class="board">
			<colgroup>
				<col width="15%" />
				<col width="40%" />
				<col width="15%" />
				<col width="15%" />
				<col width="15%" />
			</colgroup>
			<tr>
				<th>NO.</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>

			<!--
		서버로 부터 받은 데이터(도서리스트)를 보여주기 위한 부분
		BOOKS : 서버로부터 받을 데이터
		BOOK : forEach 를 사용하여 한개의 요소를 추출하여 저장할 변수
		 -->
			<c:forEach items="${board}" var="Con">
				<tr data-b_num="${Con.b_num}">
					<td>${Con.b_num}</td>
					<td>${Con.b_title}</td>
					<td>${Con.b_writer}</td>
					<td>${Con.b_date}</td>
					<td>${Con.b_hit}</td>
				</tr>
			</c:forEach>
		</table>

		<div id="page">
			<ul>
				<a href="#"><li><<</li></a>
				<a href="#"><li><</li></a>
				<a href="#"><li>1</li></a>
				<a href="#"><li>2</li></a>
				<a href="#"><li>3</li></a>
				<a href="#"><li>4</li></a>
				<a href="#"><li>5</li></a>
				<a href="#"><li>6</li></a>
				<a href="#"><li>7</li></a>
				<a href="#"><li>8</li></a>
				<a href="#"><li>9</li></a>
				<a href="#"><li>10</li></a>
				<a href="#"><li>></li></a>
				<a href="#"><li>>></li></a>
			</ul>
			<c:if test="${ not empty USER}">
				<div id="pagebutton">
					<a href="${rootPath}/board/board_write"><button>작성하기</button></a>
				</div>

			</c:if>
		</div>
	</section>


	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>