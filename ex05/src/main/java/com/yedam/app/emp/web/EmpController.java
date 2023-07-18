package com.yedam.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("/empList")
	public String selectempList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}
	//단건조회
	@GetMapping("/empInfo")
	public String selectEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo",findVO);
		return "emp/empInfo";
	}
	
	//등록-form
	
	@GetMapping("/empInsert")
	public String empInsertForm(Model model) {
		//빈캑체를 넘기면 form태그와 연결할 수있다 //페이지에서 필드를 직접 쓸수있음
		model.addAttribute("empVO", new EmpVO());
		return "emp/empInsert";
	}
	
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO) {
		empService.insertInfo(empVO);
		return "redirect:/empList";
	}
}
