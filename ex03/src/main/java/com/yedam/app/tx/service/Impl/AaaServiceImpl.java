package com.yedam.app.tx.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.tx.mapper.AaaMapper;
import com.yedam.app.tx.service.AaaService;

@Service
public class AaaServiceImpl implements AaaService{

	@Autowired
	AaaMapper aaaMapper;
	
	
	//@Transactional클래스 위치는 @Service와 함께 움직임 //bean에 등록 해주기
	@Transactional
	@Override
	public void insert() {
		//override 만하면 한개씩 Autowired 가 되기 때문에 밑에 다른게 실패해도 위에것은 자동 commit됨
		//그래서 Transactional을 처리해주면 같은 트렌젝션으로 처리하므로 하나만 실패해도 다 commit안됨)
		aaaMapper.insert("101");
		aaaMapper.insert("987");
		
		
	}
	
}
