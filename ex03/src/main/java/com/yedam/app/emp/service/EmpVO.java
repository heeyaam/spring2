package com.yedam.app.emp.service;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
//java.util.Date 는 2022/05/10 이 기본 포멧이고
//input에 Date 타입은 2022-05-10 이다 (둘다 입력형식이지 출력형식이랑은 관련없음)
//그래서 Date 압력값 처리를 위해 @DateTimeFormat  을 사용하면 처리해 준다.
@Data
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-DD")
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int managerId;
	private int departmentId;
}
