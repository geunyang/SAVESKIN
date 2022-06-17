<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/include_head.jsp"%>
<link rel="stylesheet"
	href="${rootPath}/static/css/myprofile.css?ver=2022-06-12-002">
</head>
<body>
	<%@ include file="/WEB-INF/views/include/include_nav.jsp"%>
	<section>
		<div id="profile">
			<div id="my">
				<div id="myimg">
					<img src="${rootPath}/static/image/mypofile/myprofile-icon (1).png" />
				</div>
				<div id="id_nick">
					<div id="nick">
						<i class="fa-regular fa-user icon"></i><p>${INFO.username}</p>
					</div>
					<div id="email">
						<i class="fa-regular fa-envelope icon"></i><p>${INFO.email}</p>
					</div>
				</div>
			
					<a href="${rootPath}/myprofile/myprofile-update" class="update-user">개인정보 수정하기</a>
			</div>
			<div id="mymenu">
				<ul>
					<a href="#"><li><i
							class="fa-regular fa-bell black-bell icon"></i>알림</li></a>
					<a href="#"><li><img
							src="${rootPath}/static/image/makeup.png" />내가 쓰는 제품</li></a>
					<a href="#"><li><img
							src="${rootPath}/static/image/cosmetics.png" />관심 상품</li></a>
				</ul>
			</div>
		</div>

		<div id="infor">
			<div id="myprofile">
				<ul>
					<a href="#"><li class="empha">나의 게시물</li></a>
					<a href="#"><li>화장품 언제 리콜해봄?</li></a>
					<a href="#"><li>내 화장품 어때요?</li></a>
					<a href="#"><li>요즘 20대 화장품 뭐쓰는지 추천해주세요~</li></a>
					<a href="#"><li>화장품은 화장을 해야해</li></a>
				</ul>
			</div>
			<div id="goods">
				<ul>
					<li class="empha">
						<p>내가 쓰는 화장품</p>
						<button class="oBtn">
							<i class="fa-solid fa-plus-minus emphaicon"></i>
						</button>
					</li>
					<li>숨37 워터풀 타임리프 워터 젤 크림</li>
					<li>더페이스샵 더테라피 에센셜 토닉 트리트먼트</li>
					<li>더페이스샵 치아씨드 수분 지킴 에센스 150ml</li>
					<li>오휘 미라클 모이스처 에센스 50ml</li>
					<li>숨37 워터풀 타임리프 워터 젤 크림</li>
				</ul>
			</div>
		</div>
		<!-- 내가 쓰고있는 화장품 등록 창 clascc "add" -->
		<div class="add">
			<ul>
				<li id="add_title">내가 쓰고있는 화장품 추가하기</li>
				<li>
					<div id="addbox">
						<input type="text" placeholder="화장품 이름을 입력해주세요" /><i
							class="fa-solid fa-magnifying-glass"></i>
					</div>
				</li>
			</ul>
			<div id="search_record">
				<ul>
					<li><p>숨37 워터풀 타임리프 워터 젤 크림</p></li>
					<li><p>더페이스샵 더테라피 에센셜 토닉 트리트먼트</p></li>
					<li><p>더페이스샵 치아씨드 수분 지킴 에센스 150ml</p></li>
					<li><p>오휘 미라클 모이스처 에센스 50ml</p></li>
					<li><p>숨37 워터풀 타임리프 워터 젤 크림</p></li>
					<li><p>에센셜 토닉 트리트먼트</p></li>
					<li><p>타임리프 워터 젤 크림</p></li>
					<li><p>에센셜 토닉</p></li>
				</ul>
			</div>
			<div id="exit_add">
				<button type="button" class="cBtn" type="button">X</button>
			</div>

		</div>
	</section>


	<%@ include file="/WEB-INF/views/include/include_footer.jsp"%>
	<script src="${rootPath}/static/js/myprofile.js?ver=2022-06-12-001"></script>
</body>
</html>