<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
	<!-- 단순이 뿌려질때 뿐만아니라 테그(input 등)의 일반적인 속성에도 쓸 수있음, 출력되는 DATE 형식 관리
			number type 관리  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<style type="text/css">
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList }" var="emp">
				<tr onclick="location.href='empInfo?employeeId=${emp. employeeId}'">
					<td>${emp. employeeId}</td>
					<td>${emp. firstName}</td>
					<td>${emp. lastName}</td>
					<td>${emp. email}</td>
					<td>
					<fmt:formatDate value="${emp. hireDate}" pattern="yyyy년mm월dd일"/>
					</td>
					<td>${emp. jobId}</td>
					<td>
						<fmt:formatNumber value="${emp. salary}" pattern="$#,###"/>
					</td>
					<td><button type="button">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
	printMessage(`${result}`);
	
		function printMessage(msg){
			if(msg == null || msg=='')return;
			alert(msg);
		}
	</script>
</body>
</html>