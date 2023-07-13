package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private int departmentId;
	private String departmentName;
	
	//등록시 필요한 input 태그(text를 반환)에서 넘어올때 문제가 생길 수 있으니 되도록 Integer 사용 권장 
	//int 타입은 공백도 null도 허용안하기 떄문에
	private Integer managerId;
	private Integer locationId;

}
