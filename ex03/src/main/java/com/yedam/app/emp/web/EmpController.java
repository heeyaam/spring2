package com.yedam.app.emp.web;

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

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET 처리(경로에 어떤활동을 하고 있는지 알 수있음, 외부에 데이터가 open해도 될경우 사용)
	//등록, 수정 , 삭제 	  -> POST처리()	
	
	
	//void의 경우 문자열을 따로 지정할일이 없을때 사용하기에 폴더를 보내는 우리는 사용할일이 잘없다.
	
	
	//전체조회
	@GetMapping("/empList")
	public String geEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList"; ///'WEB-INF/views/emp/empList.jsp'
	}
	
	//단건조회
	// command 객체를 사용한다는 것은 어노테이션을 사용하지 않을때 씀
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
						//값을하나만 쓸거라 객체를 쓰고 // RedirectAttributes:redirect를 쓸때 이거 써야함(
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rtt) {
		int empId = empService.insertEmp(empVO);
		String result= null;
		if(empId == -1) {
			result="정상적으로 등록되지 않았습니다.";
		}else {
			result="정상적으로 등록되었습니다.\n"+"등록된 사원의 사번은 " +empId +"입니다";
		}
		rtt.addFlashAttribute("result", result);  //flash는 단발성(사용자가 임으로 새로고침을 하는경우 살아남지 못함)
		return "redirect:empList";
	}
	
	//수정 - process
	//1) Client = JSON -> Server :@RequestBody  
	//2) Server =JSON -> Client : @ResponseBody
	@PostMapping("/empUpdate")
	@ResponseBody   //리턴되는 이쪽에 붙고 
	//return 하는 것에 대해서 페이지를 반황하는게 아니다 라는것을 알려줘야함
												//요청은 매개변수쪽에 붙음(get 방식이 아니라는 것은 바디쪽에 뿌려주겠다는의미)
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO){
		return empService.updateEmp(empVO);
	}
	
	
	
	//삭제: poocess
	@PostMapping(value="/empDelete", produces ="text/plain;charset-UTF-8")
	@ResponseBody
									//Default
	public String empDeleteProcess(@RequestParam(name="id") int employeeId) {
		Map<String, String> map = empService.deleteEmp(employeeId);
		return map.get("결과");
	}
	
	
		
	
	

}
