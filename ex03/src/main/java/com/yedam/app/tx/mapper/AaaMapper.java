package com.yedam.app.tx.mapper;

import org.apache.ibatis.annotations.Insert;

public interface AaaMapper {
	//간단한 것은 어노테이션으로 만들수 있다.
	@Insert("INSERT INTO aaa VALUES(#{valuse})")
	public void insert(String value);

}
