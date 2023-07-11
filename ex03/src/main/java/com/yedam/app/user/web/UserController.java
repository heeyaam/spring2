package com.yedam.app.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.user.service.UserListVO;
import com.yedam.app.user.service.UserVO;

@Controller
public class UserController {

	// 필드 선언되는 것은 서비스들
	@Autowired
	EmpService empService;

	// 하나 씩 맵핑된다
	@RequestMapping("/getObject") // / 는 붙여도 되고 안붙여도 됨 /특정 속성지정하지 않고 문자로 지정하면 이 경로로 멥핑이 되고 메소드에는 영향을주지않는다.
	public String getCommandObject(UserVO userVO) {
		System.out.printf("========== %s\n", userVO.getName());
		System.out.printf("========%d\n", userVO.getAge());
		return "";
	}

	@RequestMapping("/getList")
	public String getCommandObject(UserListVO listVO) {
		for (UserVO userVO : listVO.getList()) {
			System.out.printf("============%s\n", userVO.getName());
			System.out.printf("==========%d\n", userVO.getAge());
		}
		return "";
	}

	@RequestMapping("getValues")
	public String getParamValues(@RequestParam(required= false)String name,
								@RequestParam(defaultValue = "1") Integer age){
		System.out.printf("============%s\n", name);
		System.out.printf("============%d\n", age);
		
	return "";
	}
	
	@RequestMapping("users/{empid}")
	public String getPathValues(@PathVariable("empid") String id) {
		
		System.out.printf("============%s\n", id);
		return "";
	}
	
	@RequestMapping("getJsonVal")
		public String getJsonValues(@RequestBody UserVO userVO) {
			System.out.printf("============%s\n", userVO.getName());
			System.out.printf("==========%d\n", userVO.getAge());
			return "";
		}
	

}
