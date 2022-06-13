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
			<h1>화장품 제조(판매)업 정보조회</h1>
			<article class="search">
				<div>
					<input type="search" placeholder="어떤 정보를 찾으시나요?" />
					<button type="submit" id="searchalertStart">
						<i class="fa-solid fa-magnifying-glass fa-2x" style="color: white"></i>
					</button>
				</div>
			</article>
			<article class="post-list">
				<p>
					<i class="fa-regular fa-file-lines"></i>전체 1000건
				</p>
				<table class="INFOS">
					<thead>
						<tr data-entp_seq="${RECALL.ENTP_SEQ}">
							<th>번호</th>
							<th>업체명</th>
							<th>주소</th>
							<th>업체허가번호</th>
							<th>업체허가일자</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${INFOS}" var="INFO" varStatus="INDEX">
							<tr>
								<td>${INDEX.count}</td>
								<td>${INFO.ENTP_NAME}</td>
								<td>${INFO.FACTORY_ADDR}</td>
								<td>${INFO.ENTP_SEQ}</td>
								<td>${INFO.ENTP_PERMIT_DATE}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</article>
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