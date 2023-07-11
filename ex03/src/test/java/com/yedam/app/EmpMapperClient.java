package com.yedam.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void selectAllEmp() {
		//전체조회
		List<EmpVO> empList = empMapper.selectEmpAllList();
		assertTrue(!empList.isEmpty());
	}
	
	@Test
	public void selectEmpInfo() {
		//단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	@Test
	public void insertEmpInfo() {
		//등록
		
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("San-Ha");
		empVO.setEmail("shkang@naver.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(5000);
		//employee_id 기본값은 0
		empMapper.insertEmpInfo(empVO);
		assertNotEquals(empVO.getEmployeeId(), 0);  //내 값과 같냐 다르냐만 알수 있음(오류만 안나면됨)
	}
	
	@Test
	public void updateEmpSal() {
		//급여갱신
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1002);
		
		int result = empMapper.updateEmpSal(empVO, 10);
		assertEquals(result, 1);
	}
	
	@Test
	public void updateEmpInfo() {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		empVO.setEmail("sang@naver.com");
		empVO.setSalary(7000);
		
		int result = empMapper.updateEmpInfo(empVO);
		assertEquals(result, 1);
	}
	
	@Test
	public void deleteEmpInfo() {
		//삭제
		
		int result = empMapper.deleteEmpInfo(1001);
		assertEquals(result, 1);
	}
	

}
