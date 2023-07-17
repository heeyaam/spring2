<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개별조회</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	margin: auto;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>게시글번호</th>
			<td>${ boardInfo.bno }</td>
		</tr>
		<tr>
			<th>게시글제목</th>
			<td>${ boardInfo.title }</td>
		</tr>
		<tr>
			<th>게시글내용</th>
			<td><textarea>${ boardInfo.contents }</textarea></td>
		</tr>
		<tr>
			<td>게시글작성자</td>
			<td>${ boardInfo.writer }</td>
		</tr>
		<tr>
			<th>게시글등록일자</th>
			<td><fmt:formatDate value="${boardInfo. regdate }" pattern="yyyy년MM월dd일" /></td>
		</tr>
		<tr>
			<th>게시글수정일자</th>
			<td><fmt:formatDate value="${boardInfo. updatedate }" pattern="yyyy년MM월dd일" /></td>
		</tr>
		<tr>
			<th>이미지파일</th>
			<c:choose>
			<c:when test="${not empty boardInfo.image }">
				<td> <img src='<c:url value="/resources/${boardInfo.image }"/>' style="width: 200px;"></td>
			</c:when>
			<c:otherwise>
				<td>파일없음</td>
			</c:otherwise>
			</c:choose>
		</tr>

	</table>
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno }'">수정</button>
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno }'">삭제</button>
	<button type="button" onclick="location.href='boardList'">목록</button>
</body>
</html>