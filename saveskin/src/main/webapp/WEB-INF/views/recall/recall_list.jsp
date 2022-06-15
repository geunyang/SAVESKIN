<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/recall_list.css?ver=2022-05-28-001">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>
		<div class="mainbox">
			<h1>리콜 제품 리스트</h1>
			<article class="search">
				<form method="GET">
					<input type="search" placeholder="어떤 정보를 찾으시나요?" name="search" class="search1"/>
					<button type="submit" id="searchalertStart" class="recall_search">
						<i class="fa-solid fa-magnifying-glass fa-2x" style="color: white"></i>
					</button>
				</form>
			</article>
			<article class="post-list">
				<p>
					<i class="fa-regular fa-file-lines"></i>전체${TCOUNT}건
				</p>
				<table class="RECALLS">
					<thead>
						<tr>
							<th>번호</th>
							<th>상품명</th>
							<th>업체명</th>
							<th>리콜공표일</th>
							<th>출처</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${RECALLS}" var="RECALL" varStatus="INDEX">

							<tr data-recallsn="${RECALL.recallSn}">
								<td>${INDEX.count}</td>
								<td>${RECALL.productNm}</td>
								<td>${RECALL.makr}</td>
								<td>${RECALL.recallPublictBgnde}</td>
								<td>${RECALL.infoOriginInstt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
			<c:if test="${ERROR == 'FAIL'}">
				<div>일치하는 결과가 없습니다</div>
			</c:if>
			<c:if test="${ERROR == 'NULL'}">
				<div>검색어를 입력해주세요</div>
			</c:if>
		</div>
	</section>
	<div id="paging">
		<a class="arrow"><i class="fa-solid fa-angles-left"></i></a> <a
			class="arrow"><i class="fa-solid fa-angle-left"></i></a> <a
			class="on">1</a> <a>2</a> <a>3</a> <a>4</a> <a>5</a> <a>6</a> <a>7</a>
		<a>8</a> <a>9</a> <a>10</a> <a class="arrow"><i
			class="fa-solid fa-angle-right"></i></a> <a class="arrow"><i
			class="fa-solid fa-angles-right"></i></a>
	</div>
	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>