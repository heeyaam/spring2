package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET 처리(경로에 어떤활동을 하고 있는지 알 수있음, 외부에 데이터가 open해도 될경우 사용)
	//등록, 수정 , 삭제 	  -> POST처리()	
	
	//전체조회
	@GetMapping("/empList")
	public String geEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList"; ///'WEB-INF/views/emp/empList.jsp'
	}
	
	//단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";	
		}
	
	//등록 -form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	//등록 - process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rtt) {
		int empId = empService.insertEmp(empVO);
		String result= null;
		if(empId == -1) {
			result="정상적으로 등록되지 않았습니다.";
		}else {
			result="정상적으로 등록되었습니다.\n"+"등록된 사원의 사번은 " +empId +"입니다";
		}
		rtt.addFlashAttribute("result", result);
		return "redirect:empList";
	}
	
	//수정 - process
	//1) Client = JSON -> Server :@RequestBody
	//2) Server =JSON -> Client : @ResponseBody
	@PostMapping("/empUpdate")
	@ResponseBody
	//(json으로 데이터 받는 다는 것)return 하는 것에 대해서 페이지를 반황하는게 아니다 라는것을 알려줘야함
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.updateEmp(empVO);
	}
	
	
		
	
	

}
