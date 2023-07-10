package com.yedam.app;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx
		= new GenericXmlApplicationContext("classpath:applicationContext.xml");    //resources에 만든 빈즈 파일(spring bean configuration 파일로 만들때 beans만 선택)
		//1번: 컨테이너 작동(강제로 bean을 주입: 얘는 실제 동작하는 class는 모르지만 동작은함)
		
		TV tv =(TV)ctx.getBean("tv");     
		// "tv" 는 get bean의 id
		tv.on();
	}

}
