<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
	<form>
		<div>
			<label>부서번호 : <input type="number" name="departmentId"
				value="${deptInfo.departmentId }" readonly>
			</label>
		</div>
		<div>
			<label>부서이름 : <input type="text" name="departmentName"
				value="${deptInfo.departmentName }">
			</label>
		</div>
		<div>
			<label>팀장번호 : <input type="number" name="managerId"
				value="${deptInfo.managerId }">
			</label>
		</div>
		<div>
			<label>위치번호 : <input type="number" name="locationId"
				value="${deptInfo.locationId }">
			</label>
		</div>
		<div>
			<button type="submit">수정</button>
			<button type="button" onclick="location.href='deptList'">목록</button>
		</div>
	</form>

	<script>
		let msg = `${message}`;
		if(msg != null && msg != '') alert(msg);
		
		
		let inputList = document.querySelectorAll('form input');
		
		let formObj = {};
		inputList.forEach(tag => {
			formObj[tag.name] = tag.value;
		});
		
		console.log(formObj);
		
		$('form').on('submit', ajaxDeptUpate);
		
		function ajaxDeptUpate(event){
			event.preventDefault();
			
			let obj = serializeObject();
			
			$.ajax({
				url : 'deptUpdate',
				type : 'post',
				contentType : 'application/json',
				data : JSON.stringify(obj)
			})
			.done( data => {
				if(data != null && data['결과'] == 'success'){
					alert('수정되었습니다. 부서번호 :'+ data["부서번호"]);
				}else{
					alert('수정되지 않았습니다 정보를 확인해 주세요')
				}
			})
			.fail( reject => console.log(reject));
		};
		
		function serializeObject() {
			let formData = $('form').serializeArray();
			
			let formObj = {};
			$.each(formData, function(idx, obj) {
				formObj[obj.name] = obj.value;
				
			});
			return formObj;
			
		}
		
		
	</script>
</body>
</html>