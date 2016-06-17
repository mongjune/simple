<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	display: inline; /*  세로나열을 가로나열로 변경 */
	border-left: 1px solid #999; /* 각 메뉴의 왼쪽에 "|" 표시(분류 표시) */
	font: bold 12px Dotum; /* 폰트 설정 - 12px의 돋움체 굵은 글씨로 표시 */
	padding: 0 10px; /* 각 메뉴 간격*/
}
</style>

</head>
<body>
<div class="listTable">
	<table>
		<thead>
			<tr role="row">
				<th>번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>등록시간</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="arr" items="${list }">
				<tr role="row" class="odd">
					<td>${arr.bno }</td>
					<td><a
						href="/board/read?bno=${arr.bno }&page=${pageMaker.cri.page}">
							${arr.title }</a></td>
					<td>${arr.writer }</td>
					<td>${arr.regdate }</td>
					<td>${arr.viewcnt }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

	<div class="text-center">
		<ul class="pagination">

			<c:if test="${pageMaker.prev}">
				<li><a href="listPage?page=${pageMaker.startPage - 1}">&laquo;</a></li>
			</c:if>

			<c:forEach begin="${pageMaker.startPage }"
				end="${pageMaker.endPage }" var="idx">
				<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
					<a href="listPage?page=${idx}">${idx}</a>
				</li>
			</c:forEach>

			<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				<li><a href="listPage?page=${pageMaker.endPage +1}">&raquo;</a></li>
			</c:if>

		</ul>
	</div>
</body>
</html>
