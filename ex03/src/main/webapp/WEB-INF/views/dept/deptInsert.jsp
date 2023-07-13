<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서등록</title>
</head>
<body>
<form action="deptInsert" method="post">
		<div>
		<label>부서이름 : <input type="text" name="departmentName" required> </label>
		</div>
		<div>
		<label>팀장번호 : <input type="number" name="managerId"> </label>
		</div>
		<div>
		<label>위치번호 : <input type="number" name="locationId"> </label>
		</div>
		<div>
		<button type="submit">등록</button>
		<button type="button" onclick="location.href='deptList'">목록</button>
		</div>
	</form>
</body>
</html>