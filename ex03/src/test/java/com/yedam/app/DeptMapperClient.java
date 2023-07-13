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

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class DeptMapperClient {
	
	@Autowired
	DeptMapper deptMapper;
	
	@Test
	public void selectDeptAllList() {
		List<DeptVO> deptList = deptMapper.selectDeptAllList();
		assertTrue(!deptList.isEmpty());
	}
	
	@Test
	public void selectDeptInfo() {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(20);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		assertEquals(findVO.getDepartmentName(),"Marketing");
		
	}
	
	@Test
	public void insertDeptInfo() {
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentName("Home");
		deptVO.setManagerId(200);
		deptVO.setLocationId(1700);
		
		deptMapper.insertDeptInfo(deptVO);
		assertNotEquals(deptVO.getDepartmentId(), 0);
	}
	
	@Test
	public void updateDeptInfo() {
		
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(20);
		
		DeptVO findVO = deptMapper.selectDeptInfo(deptVO);
		System.out.println(findVO);
		
	}
	
}
