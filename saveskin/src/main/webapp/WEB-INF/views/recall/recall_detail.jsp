<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/recall_detail.css?ver=2022-05-28-001">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>
		<div class="mainbox">
			<h1>리콜 제품 상세</h1>
			<article class="details">
				<h3>리콜대상 상품정보</h3>
				<c:forEach items="${RECALLS}" var="RECALL">
					<table>
						<tr>
							<th>상품명</th>
							<td>${RECALL.productNm}</td>
						</tr>
						<tr>
							<th>제조사</th>
							<td>${RECALL.makr}</td>
						</tr>
						<tr>
							<th>제조연월일</th>
							<td>${RECALL.mnfcturPd}</td>
						</tr>
						<tr>
							<th>제조번호</th>
							<td>${RECALL.mnfcturNoInfo}</td>
						</tr>
					</table>
					<h3>리콜이유</h3>
					<table>
						<tr>
							<th>리콜구분</th>
							<td>${RECALL.recallSe}</td>
						</tr>
						<tr>
							<th>리콜공표기간</th>
							<td>${RECALL.recallPublictEndde}</td>
						</tr>
						<tr>
							<th>출처</th>
							<td>${RECALL.infoOriginInstt}</td>
						</tr>
						<tr>
							<th>결함의 내용</th>
							<td>${RECALL.shrtcomCn}</td>
						</tr>
					</table>
					<h3>리콜방법</h3>
					<table>
						<tr>
							<th>문의처, 업체주소</th>
							<td>${RECALL.recallEntrpsInfo}</td>
						</tr>
					</table>
 				</c:forEach>
			</article>
		</div>
	</section>

	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
</body>
</html>