package com.yedam.app.dept.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;

@Service
public class DeptServiceImpl implements DeptService {

	// db가져오기
	@Autowired
	DeptMapper deptMapper;

	@Override
	public List<DeptVO> selectDeptAllList() {

		return deptMapper.selectDeptAllList();
	}

	@Override
	public DeptVO selectDeptInfo(DeptVO deptVO) {

		return deptMapper.selectDeptInfo(deptVO);
	}

	@Override
	public int insertDeptInfo(DeptVO deptVO) {

		int result = deptMapper.insertDeptInfo(deptVO);

		if (result == 1) {
			return deptVO.getDepartmentId();
		} else {
			return -1;
		}
	}

	@Override
	public Map<String, String> updateDeptInfo(DeptVO deptVO) {
		Map<String, String> map = new HashMap<>();

		map.put("부서번호", String.valueOf(deptVO.getDepartmentId()));

		int result = deptMapper.updateDeptInfo(deptVO);

		if (result > 0) {
			map.put("결과", "success");
		} else {
			map.put("결과", "fail");
		}
		return map;
	}

	@Override
	public Map<String, String> deleteDeptInfo(int deptId) {
		Map<String, String> map = new HashMap<>();
		
		map.put("부서번호", String.valueOf(deptId));

		int result = deptMapper.deleteDeptInfo(deptId);

		if (result > 0) {
			map.put("결과", "success");
		} else {
			map.put("결과", "fail");
		}
		return map;
	}

}
