<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글등록</title>
</head>
<body>
	<form name="insertForm" action="boardInsert" method="post">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td><input type="text" name="regdate"></td>
			</tr>
		</table>
		
		<button type="submit">등록</button>
		<button type="reset">취소</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	
	<script>
		document.querySelector('form[name="insertForm"]')
				.addEventListener("submit" , function(e){
					e.preventDefault();
					
					let title = document.getElementsByName('title')[0];
					let writer = document.getElementsByName('writer')[0];
					
					if(title.value == ''){
							alert('제목이 입력되지 않았습니다.');
							title.focus();
							return;
					}
					if(writer.value == ''){
						alert('작성자가 입력되지 않았습니다.')	;
						writer.focus();
						return;
					}
					
					insertForm.submit();
				});
	</script>
</body>
</html>