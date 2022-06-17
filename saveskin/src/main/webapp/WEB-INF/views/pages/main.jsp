<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/mainpage.css?ver=2022-06-16-002">


<div id="search-background">
	<div id="search">
		<ul>
			<li><input type="text" name="search" placeholder="어떤 정보를 찾으시나요?" />
			</li>
			<li>
				<button id="searchalertStart">
					<i id="icon" class="fa-solid fa-magnifying-glass fa-lg"></i>
				</button>
			</li>
			<li id="recall-box-wrap">
				<div id="recall-box">
					<c:forEach items="${RECALLS}" var="RECALL" varStatus="INDEX">

						<div data-recallsn="${RECALL.recallSn}">

							<a>&lt;${INDEX.count}&gt; ${RECALL.productNm}</a>
						</div>
					</c:forEach>
				</div>
			</li>
		</ul>
	</div>
</div>
<section>
	<article>
		<div class="table-title">
			<h1>리콜 제품 리스트</h1>
			<a href="${rootPath}/recall/recall_list">더보기<i
				class="fa-solid fa-angle-right"></i></a>
		</div>
		<div class="border-bottom"></div>

		<c:forEach items="${RECALLS}" var="RECALL">
			<div data-recallsn="${RECALL.recallSn}">
				<table>
					<tr>
						<td>${RECALL.productNm}</td>
						<td>${RECALL.recallPublictBgnde}</td>
					</tr>
				</table>
			</div>
		</c:forEach>


	</article>
	<article>
		<div class="table-title">
			<h1>화장품 심사정보 리스트</h1>
			<a href="${rootPath}/recall/recall_list">더보기<i
				class="fa-solid fa-angle-right"></i></a>
		</div>
		<div class="border-bottom"></div>

		<c:forEach items="${INFOLIST}" var="INFO">
				<table>
					<tr>
						<td>${INFO.ENTP_NAME}</td>
						<td>${INFO.ENTP_PERMIT_DATE}</td>
					</tr>
				</table>
		</c:forEach>
		
	</article>
	<article>
		<div class="table-title">
			<h1>커뮤니티</h1>
			<a href="${rootPath}/board/board_list">더보기<i
				class="fa-solid fa-angle-right"></i></a>
		</div>
		<div class="border-bottom"></div>
		<c:forEach items="${BOARDLIST}" var="BOARDLIST" varStatus="INDEX">
				<table>
					<tr>
						<td>${INDEX.count}</td>
						<td>${BOARDLIST.b_title}</td>
						<td>${BOARDLIST.b_hit}</td>
					</tr>
				</table>
		</c:forEach>
	</article>
</section>

