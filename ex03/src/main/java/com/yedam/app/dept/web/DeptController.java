package com.yedam.app.dept.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class DeptController {
	
	@Autowired
	DeptService deptService;
	
	//전체조회 (조회는 반드시 get이어야함 post는 바디가 필요하기에 바디에 값이하나라도 존재해야하기때문에)
	@GetMapping("/deptList")
	public String selectDeptAllList(Model model) {
		model.addAttribute("deptList", deptService.selectDeptAllList());
		return "dept/deptList";
	}
	
	//단건조회
	@GetMapping("/deptInfo")
								//service에서 커멘드객체를 원함 param type이면 따로 클래스만들어줘애함
	public String selectDeptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.selectDeptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/deptInfo";
	}
	
	//등록폼
	@GetMapping("/deptInsert")
	public String deptInserForm() {
		return "dept/deptInsert";
	}
	//등록
	@PostMapping("/deptInsert")
	public String deptInsertProcess(DeptVO deptVO, RedirectAttributes rtt) {
		int result = deptService.insertDeptInfo(deptVO);
		String uri = null;
		String message = null;
		if(result == -1) {
			message = "정상적으로 등록되지 않았습니다";
			uri ="deptList";
		}else {
			message = "정상적으로 등록이 되었습니다 \n";
			message += "부서번호 : " + result;
			uri ="deptInfo?departmentId=" + result;
					
		}
		rtt.addFlashAttribute("message", message);
		return "redirect:" +uri;
		// return "redirect:deptInfo?departmentId="+result; //보내야하는 데이터가 추가될때 사용하기좋음
	}
	
	
	//수정(json type으로 주고 받기)
	@PostMapping("/deptUpdate")
	@ResponseBody
	public Map<String, String> deptUpdateProcess(@RequestBody DeptVO deptVO){
		return deptService.updateDeptInfo(deptVO);
	}
	
	
	//삭제
	@PostMapping("/deptDelete")
	@ResponseBody
	public String deptDeleteProcess(@RequestParam int deptId) {
		Map<String, String> map = deptService.deleteDeptInfo(deptId);
		return map.get("결과");
	}
}
