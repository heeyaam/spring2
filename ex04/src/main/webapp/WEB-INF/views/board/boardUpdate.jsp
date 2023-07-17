<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<form name="updateForm">
		<table>
			<tr>
				<th>번호</th>
				<td><input type="number" name="bno" value="${ boardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${ boardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${ boardInfo.writer }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents">${ boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<th>이미지</th>
				<td><input type="text" name="image" value="${boardInfo.image }"></td>
			</tr>
			<tr>
				<th>수정일자</th>
				<td><input type="date" name="updatedate" value='<fmt:formatDate value="${boardInfo. updatedate }"
							pattern="yyyy-MM-dd" />'></td>
			</tr>
		</table>
		<button type="submit">등록</button>
		<button type="reset">취소</button>
		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	
	<script>
		$('form').on('submit', function(e){
			let objData =serializeObject();
			
			$.ajax({
				url : 'boardUpdate',
				method : 'post',
				data : objData
			})
			.done(data => {
				if(data.result){
				let message ="수정되었습니다. \n" +data.boardInfo.bno;
				alert(message);
				}else{
					alert("수정되지 않았습니다. 정보를 확인해 주세요");
				}
			})
			.fail(reject => console.log(reject));
			
			
			return false;
		});
		
		function serializeObject(){
			let formData = $('form').serializeArray();
			// [{ name : 'title' , value : 'hello'}, ...
			let formObject = {};
			$.each(formData, function(idx,obj){
				let field = obj.name;
				let val = obj.value;
				
				formObject[field] = val;
			});
				return formObject;
		}
	</script>
</body>
</html>