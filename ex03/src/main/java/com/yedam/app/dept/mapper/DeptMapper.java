package com.yedam.app.dept.mapper;

import java.util.List;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	
	//전체조회(돌아오는 값 여러개이므로 list 타입으로 지정)
	public List<DeptVO> selectDeptAllList();
	
	//개별 조회(의도적으로 한건만 반환되게 하는 것)
	public DeptVO selectDeptInfo(DeptVO deptVO);
	
	//등록(기본정보가 필요하기에 무조건 VO 객체쓰기)
	public int insertDeptInfo(DeptVO deptVO);
	
	//수정(어느정도 기본정보 필요하기에 VO 객체 쓰기)
	public int updateDeptInfo(DeptVO deptVO);
	
	//삭제(primary key 로 조건 권장)
	public int deleteDeptInfo(int deptId);
}
